public class HomeWork2 {
    /*
    Задание 1
    Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20
    (включительно), если да – вернуть true, в противном случае – false.
    */
    static boolean checkSumm(int num1, int num2) {
        boolean result = ((num1+num2)>10 && (num1+num2)<20) ? true:false;
        return result;
    }

    /*
    Задание 2
    Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    */
    static void printSign(int num) {
        System.out.println ((num>=0) ? "Число положительно":"Число отрицательно");
    }

    /*
    Задание 3
    Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число
    отрицательное, и вернуть false если положительное.
    */
    static boolean checkSign(int num) {
        return ((num<0) ? true:false);
    }

    /*
    Задание 4
    Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль
    указанную строку, указанное количество раз;
    */
    static void printString(String string, int repetition){
        for (int i=1; i<=repetition; i++){
            System.out.println(string);
        }
    }

    /*
    Задание 5 (*)
    Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true,
    не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й
    – високосный.
    */
    static boolean leapYear(int year){
        // помнится мне, что в этой задаче была изюминка, но какая - уже не помнится...
        // поэтому делаю в лоб и только по заданным условиям, а их по-моему маловато: что-то с годом там не совсем «чисто».
        boolean result = false;
        // промежуточные логические состояния
        boolean a = ((year % 4)==0);
        boolean b = ((year % 400)==0);
        boolean c = ((year % 100)==0);
        // определение високосности
        // можно и в одно условие, но я стараюсь избегать сложных условий - так они лучше читаются.
        if (a&b)  {
            result = true;
        } else if (a&c) {
            result = false;
        } else if (a) {
            result = true;
        };
        return result;
    }
    /*
    Вызовы методов добавляю для проверки, хоть в задании и нет такого пункта
    */
    public static void main(String[] args) {
        //1
        System.out.println (checkSumm(10,2));   // true
        System.out.println (checkSumm(10,12));  // false
        //2
        printSign(10);                          // Число положительно
        printSign(-2);                          // Число отрицательно
        //3
        System.out.println (checkSign(10));     // false
        System.out.println (checkSign(-2));     // true
        //4
        printString("мама мыла раму", 3);       // вывелось трижды
        //5*
        System.out.println ("3 г.    - "+leapYear(3));         // false
        System.out.println ("4 г.    - "+leapYear(4));         // true
        System.out.println ("100 г.  - "+leapYear(100));       // false
        System.out.println ("400 г.  - "+leapYear(400));       // true
        System.out.println ("1900 г. - "+leapYear(1900));      // false

    }
}
