public class HomeWorkApp {

    static void printThreeWords(){
        // вывожу одной строкой
        System.out.println("Orange\nBanana\nApple");
    }

    static void checkSumSign(){
        // здесь логичней было бы засылать значения в метод, но это противоречит заданию
        int a,b;
        a=-333; b=12;
        System.out.println(a+b>=0? "Сумма положительная":"Сумма отрицательная");
    }

    static void printColor(){
        // здесь логичней было бы засылать значение в метод, но это противоречит заданию
        int value = 101;
        String res;
        if (value<=0) {
            res = "Красный";
        } else if (value>0 & value<=100) {
            res = "Желтый";
        } else {
            res = "Зеленый";
        }
        System.out.println(res);
    }

    static void compareNumbers() {
        // …
        int a,b;
        a=333; b=12;
        System.out.println(a>=b ? "a >= b":"a < b");
    }

    public static void main(String[] args) {
        // задание 6, вызов метода printThreeWords()
        printThreeWords();
        // задание 6, вызов метода checkSumSign()
        checkSumSign();
        // задание 6, вызов метода printColor()
        printColor();
        // задание 6, compareNumbers()
        compareNumbers();
    }

}
