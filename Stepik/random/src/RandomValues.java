/**
 * Пример использования random
 *
 * @author : Хильченко А.Н
 * @version : номер, дата
 */
import java.util.Random;

/**
мы можем просто получить любое целое, в том числе и отрицательное,
мы получим числа в интервале с 0 до указанного числа (крмое доубла)
если доубла (от 0 до 1) умножить на 10 в какойто степени то получим в интервале до 10, 100, и так далее
если нужно получить в интервале от 5 до 10 (min и max), то тут вообще все подругому...
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
как-то так... но так нужно скорей редко чем часто. и в последнем случае нужно импортировать math, а еще можно
получить случаного boolean-а
*/

/*
вывод:
154272811	5	true	0.09868207246531924
449697438	0	false	0.28729240618805973
-917473523	0	true	0.32594108482756656
966798341	7	true	0.3825517339662452
542829948	7	false	0.9126249009724877
-2119930539	3	false	0.560400548928042
1867332459	0	true	0.20626818881811404
-2031069978	8	true	0.5203617577008628
… логика короче ясна...
 */

public class RandomValues {

    static Random random = new Random();

    public static int getIntValue(){
        // целое
        return random.nextInt();
    }

    public static boolean getBooleanValue(){
        // true или false
        return random.nextBoolean();
    }

    public static int getIntValue0to10(){
        // целое от 0 до 10 (0-9)
        return random.nextInt(10);
    }


    public static double getDoubleValue(){
        // от 0 до 1
        return random.nextDouble();
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++){
            System.out.println(getIntValue()+"\t"+getIntValue0to10()+"\t"+getBooleanValue()+"\t"+getDoubleValue());
        }
    }
}


