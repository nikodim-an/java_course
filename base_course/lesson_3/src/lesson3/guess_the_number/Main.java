package lesson3.guess_the_number;
// модифицировать код атак чтобы игра могла загадывать числа большого размера
/*
при начале игры пользователю будет предоставлена возможность указать сложность
уровень сложности, умноженный на 10 и даст пороговое значение интервала натура
льных чисел для отгадывания...
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // внесенная модификация
        System.out.println("Укажите уровень сложности 1-9");
        int level = 0;
        while (level == 0) {
            if (scanner.hasNextInt()) {level = scanner.nextInt();}
        }
        // конец модификации
        System.out.println("Ваша задача угадать число.");
        int range = 100*level;
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
        scanner.close();
    }
}

