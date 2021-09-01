package lesson5.guess_the_number;
/*
Задача:
1) модифицировать данный код так чтобы игра шла с постоянно повышающимся уровнем
 а по прохождению максимального выводила сообщенеи с поздравлениями
2) оптимизирвоать вызов метода тура для облегчения запуска.
*/

import java.util.Scanner;

public class Main {

     // объявил сканер за пределами метода чтобы он был доступен во всех методах класса
     public static Scanner scanner = new Scanner(System.in);

     public static void main(String[] args) {
        System.out.println("Игра ведется с повышением уровня сложности (1-9)");
        System.out.println("Ваша задача угадать число.");
        for ( int i= 1; i<10; i++) turn(i);
        scanner.close();
    }

    public static void turn(int level){
        int range = 100 * level;
        int number = (int) (Math.random() * range);
        while (true) {
            System.out.println("Угадайте число от 0 до " + range);
            int input_number = scanner.nextInt();
            if (input_number == number) {
                System.out.println("Вы угадали.");
                break;
            } else if (input_number > number) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.println("Загаданное число больше");
            }
        }
    }
}
