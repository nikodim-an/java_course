/**
 * Класс Main
 *
 * @author : Хильченко А.Н
 * @project : lambda
 * @date : 11.12.2021
 * @comments :
 */

import java.util.*;

@FunctionalInterface
interface MyInterface {
    double getValue(int var);
}



public class Main {
    static Integer[] intArray = {1,2,4,3,6,7,8,10,333};
    static int intValue = 555;
    static int x = 10;
    String strValue = "мама мыла раму";

    public static void main(String[] args) {

        // Если использовать функциональный интерфейс
        MyInterface alpha = i-> i*x; // тут к интерфейсу привязывается конкретная функция
        for (int i = 0; i < 100; i++) {
            System.out.println(alpha.getValue(i));
            };
        System.out.println("-----------------------------------------------");
        MyInterface beta = i->i*i;
        for (int i = 0; i < 20; i++) {
            System.out.println(beta.getValue(i));
        }

        // пример использования квадроточия
        System.out.println("-----------------------------------------------");
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(intArray));
        list.forEach(System.out::println);
        System.out.println("-----------------------------------------------");
        list.forEach(x -> System.out.println(x)); // интерфейс тут не создается!!!

    }

}

