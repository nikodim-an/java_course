package ru.khan.dataTypes;
import java.util.Arrays;


public class Arrays_example {
    /*
    массивы - примитывный тип данных, ноу  него есть обертка (как и у прочих) — java.util.Arrays
    */
    public static String[] arrayExample1 = {"Срочно", "Не срочно", "Можно потом"};

    public static void arrayUse() {
        // вывод массива
        System.out.println(arrayExample1.toString()); // [Ljava.lang.String;@6acbcfc0 — это его идентификатор
        System.out.println(Arrays.toString(arrayExample1)); // [Срочно, Не срочно, Можно потом] — это его содержимое
        // вывод элемента массива
        System.out.println(arrayExample1[1]); // Не срочно
        // запись в элемент массива
        arrayExample1[1] = "Можно не делать совсем";
        System.out.println(arrayExample1[1]); // Можно не делать совсем
        // перебор элементов массива
        for (int i=0; i<arrayExample1.length; i++) {
            System.out.println(arrayExample1[i]); // вывелись все три
        }
        // многомерные массивы - аналогичны аналогичным в других языках
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];

        int i=0, j=0;
        for (int k=0; k<a3.length; k++) {

            if (i > a1.length-1) {
                int a = a2[j];
                a3[k] = a;
                j++;
            }
            else if (j > a2.length-1) {
                int a = a1[i];
                a3[k] = a;
                i++;
            }
            else if (a1[i] < a2[j]) {
                int a = a1[i];
                a3[k] = a;
                i++;
            }
            else {
                int b = a2[j];
                a3[k] = b;
                j++;
            }
        }

        System.out.println(Arrays.toString(a3));
        return a3;
    }
}
