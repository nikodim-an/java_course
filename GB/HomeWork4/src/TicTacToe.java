/**
 * Домашняя работа № 4
 * "Консольная игра крестики-нолики"
 *
 * @author : Хильченко А.Н
 * @version : 15.10.2021
 */

/*
В коде будут приведены только комментарии касающеся кода.
Логику того, как я решал задания и мотивы которые мной при этом двигали я изложил в readme.md файле
*/

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

class TicTacToe {
    Random random;
    Scanner scanner;
    final char SIGN_X = '\u2717'; // символ крестика — "✗"
    final char SIGN_O = '\u25EF'; // символ нолика — "◯"
    final char SIGN_EMPTY = '.';
    char[][] map;
    // добавлю глобальные для класса переменные размерности карты и величины победной серии
    // они не будут финализированны, поскольку через них будет задаваться сложность...
    int MAP_SIZE = 3;             // размер карты по умолчанию
    int WIN_SERIES = 3;           // победная серия по умолчанию

    public static void main(String[] args) {
        if (args.length != 0) {
            new TicTacToe(args).game();
        } else {
            new TicTacToe().game();
        }
    }

    TicTacToe() { // конструктор для карт по умолчанию
        map = new char[MAP_SIZE][MAP_SIZE];
        random = new Random();
        scanner = new Scanner(System.in);
    }

    TicTacToe(String[] args) { // конструктор для карт с «повышенной» сложностью
        MAP_SIZE = Integer.parseInt(args[0]); // первый параметр вызова программы
        WIN_SERIES = Integer.parseInt(args[1]); // второй параметр вызова программы
        map = new char[MAP_SIZE][MAP_SIZE];
        random = new Random();
        scanner = new Scanner(System.in);
    }

    void game() {
        initTable();
        while (true) {
            printTable();
            turnHuman();
            if (isWin(SIGN_X)) {
                System.out.println("Победил человек!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Больше ходить некуда! Ничья…");
                break;
            }
            turnAi();
            if (isWin(SIGN_O)) {
                System.out.println("Победил компьютер!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Больше ходить некуда! Ничья…");
                break;
            }
        }
        printTable();
    }

    void initTable() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = SIGN_EMPTY;
            }
        }
    }

    void printTable() {
        // todo По идее нужно очистить вывод в консли, чтобы перерисовывать поле,
        // но это далеко не тривиальная (как оказалось), а что самое главное - и не кроссплатформенная задача.
        System.out.print("  ");
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println("←(x)");
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("↑(у)");
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.println("Куда ходим (x y) — (числа 1.." + (MAP_SIZE) + ")?:");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));   // систему «координат» нужно вывернуть,
        map[y][x] = SIGN_X;             // потому что массив хранит строки
    }

    void turnAi() {
        int x, y;
        do {
            x = random.nextInt(MAP_SIZE);
            y = random.nextInt(MAP_SIZE);
        } while (!isCellValid(x, y));
        map[x][y] = SIGN_O;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || x > (MAP_SIZE - 1) || y < 0 || y > (MAP_SIZE - 1)) {
            return false;
        }
        return map[x][y] == SIGN_EMPTY;
    }

    boolean isWin(char ch) {
        ArrayList<String> series = new ArrayList<>(); // создал строковый список
        // добавлю строки, эквивалентные строкам и столбцам карты
        for (int i = 0; i < MAP_SIZE; i++) { // перебираю строки и столбцы
            String row = "";
            String column = "";
            for (int j = 0; j < MAP_SIZE; j++) {
                row += map[i][j];    // собрал строку в строку
                column += map[j][i]; // собрал столбец в строку
            }
            series.add(row);
            series.add(column);
            // добавил строку и колонку (для i=1 — это первая строка и первая колонка, для i=2 — это вторая строка и вторая колонка и т.д...)
        }
        // добавлю строки, эквивалентные линиям параллельным диагоналям
        // «отсекать» строки, длина которых меньше выигрышной ситуации алгоритмически не буду - сложность математического алгоритма в этом случае возрастает в разы, достаточно ппросто не добавлять те элементы которые длиной меньше выигрышной комбинации
        for (int l = ((-1) * MAP_SIZE) + 1; l < MAP_SIZE; ++l) { // выборка линий, параллельных главной и второстепенной диагоналям
            String lineMain = "";       // выборка линий, параллельных главной диагонали
            String lineSecondary = "";  // выборка линий, параллельных второстепенной диагонали
            for (int i = 0; i < MAP_SIZE - Math.abs(l); ++i) {
                if (l <= 0) {
                    lineMain += map[i][i - l];
                    lineSecondary += map[MAP_SIZE - 1 - i][i - l];
                } else {
                    lineMain += map[i + l][i];
                    lineSecondary += map[MAP_SIZE - 1 - i - l][i];
                }
            }
            if (lineMain.length() >= WIN_SERIES) { // отсек все строки что меньше выигрышной серии
                series.add(lineMain);
            }
            if (lineSecondary.length() >= WIN_SERIES) {
                series.add(lineSecondary);
            }
        }

        // получу строку с выигрышной комбинацией для проверки ее вхождения в выборку
        String win_combination = "";
        for (int i = 0; i < WIN_SERIES; i++) {
            win_combination += ch;
        }
        // проверю вхождение выигрышной серии в выборку
        for (String i: series) {
            if (i.contains(win_combination)) {
                return true;
            }
        }
        return false;
    }

    boolean isTableFull() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == SIGN_EMPTY) {
                    return false;
                }
            }
        }
        return true;

    }
}