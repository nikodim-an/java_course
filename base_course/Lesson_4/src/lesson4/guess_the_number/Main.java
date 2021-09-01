package lesson4.guess_the_number;
/*
 модифицировать код так чтобы обработка одного тура в игре проводилась в отдельном методе.
 отладить полученный код с помощью отладчика
 (модифицирую код из предыдущего домfшнего задания - свое всегда инетересней…
 а отладчик тут такой-же как в PyCharm и пользоваться я им умею.)
*/

import java.util.Scanner;

public class Main {

     // объявил сканер за пределами метода чтобы он был доступен во всех методах класса
     public static Scanner scanner = new Scanner(System.in);

     public static void main(String[] args) {
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
        turn(range, number);
        scanner.close();
    }

    public static void turn(int range, int number){
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
