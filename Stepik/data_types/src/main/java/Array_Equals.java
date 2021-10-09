/**
 *   Сравнение двух строк
 *   @author : Хильченко А.Н.
 *   @version : от 09.10.2021
 *
 */

class Array_Equals {
    static String a = "Мама мыла раму";
    static String b = "Мама мыла раму";
    static String c = "Мама мыла папу";

    public static void main(String[] args) {
        System.out.println(a.equals(b)); // true - равны
        System.out.println(a.equals(c)); // false
        System.out.println(c.equals(b)); // false
    }
}
