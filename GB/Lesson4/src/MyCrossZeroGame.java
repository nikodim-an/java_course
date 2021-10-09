/**
 * Java 1.  Домашняя работа №4
 *  «Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку»
 *
 * @author : Хильченко А.Н
 * @version : 08.10.2021
 *
 */

import java.util.Scanner;
import java.util.Arrays;

public class MyCrossZeroGame {
    // константы
    // обозначения
    static char DOT_X = 'X';
    static char DOT_0 = '0';
    static char DOT_EMPTY = '.';
    // состояния игры и сообщения
    static String GS_RUN = "Игра продолжается";
    static String GS_HUMAN_WIN = "Победил человек !!!";
    static String GS_PC_WIN = "Победил компьютер";
    // карта
    static int MAP_SIZE = 3;
    static char[][] map = new char[MAP_SIZE][MAP_SIZE];
    // сканер
    static Scanner scanner = new Scanner(System.in);

   static void initMap() {
        for (int i=0; i<MAP_SIZE; i++) {
            for (int j=0; j<MAP_SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

   static void showMap () {
        //todo как то нужно очистить вывод в консли, чтобы перерисовывать поле
        System.out.print("  ");
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print (map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isFullMap () {
        boolean result = true;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == '.') {
                    result = false;
                }
            }
        }
        return result;
    }

    static boolean isPointEmpty(int x, int y) {
        return (map[x][y]=='.'); // я учел ваши замечания по прошлому ДЗ…
    }


    static boolean setPoint (int x, int y, char dot) {
        if (isPointEmpty(x, y)) {
            System.out.println("Вы походили в точку ("+x+","+y+")");
            map[x][y] = dot;
            return true;
        } else {
            System.out.println("Эта точка уже занята, сделайте другой ход…");
            turnHuman(); // такой вот вариант рекурсии…
        }
        return false;
    }

    static void turnHuman() {
        System.out.println("Введите точку, в которой хотите поставить «X», в формате X,Y");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        setPoint(x,y, DOT_X);
    }

    public static void turnPC () {
        // ход машины
    }

    public static String getGameStatus() {
        return "игра продолжается";
    }

    public static void main(String[] args) {
        initMap ();
        showMap();
        String gameStatus;
        while ((!isFullMap())|(!)) { // что-то тут в корне не то.... переосмыслить
            // нужно сделать ход человека и ход компьютера, после каждого проверять на наличие победы и перерисовывать карту.
            gameStatus = getGameStatus();
            if Arrays.equals(gameStatus, GS_RUN) {
                turnHuman();
                }
            if Arrays.equals(gameStatus, GS_RUN) {
                turnPC();
            }

            break;
        }
    }

}
