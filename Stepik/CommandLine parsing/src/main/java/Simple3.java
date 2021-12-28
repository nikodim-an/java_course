/**
 * Класс Simple3
 *
 * @author : Хильченко А.Н
 * @project : CommandLine parsing
 * @date : 29.12.2021
 * @comments :
 */

import java.util.*;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class Simple3 {
    @Parameter(names = "-v",description = "переданное снаружи значение")
    private static Integer value = 333; // это то что будет по умолчанию, если не будет такого параметра
        // так можно передать любой тип данных

    @Parameter(names = {"--help","?","-h"}, help = true, description = "Справка")
    private static boolean help;
        // указано значение если параметр встретился,
        // это нужно чтобы написать только параметр не указывая его значение - как это делается с командами


    public static void main(String[] args) {
        Simple3 app = new Simple3(); // экземпляр запускаемого класса.
            // по-моему это костыль, но он пришел из документации
        JCommander jc = new JCommander();
        jc.addObject(app);
        jc.setProgramName("ИМЯ ПРОГРАММЫ"); // 17 и 18 пункты справки разработчика, нужно для корректного вывода справки
        try {
            jc.parse(args);
            // теперь параметры распарсены и их значения внесены в нужные преременные
            if (help == true) jc.usage(); // выведется справка, сформированная автоматически
            System.out.println("Стартовое значение аргумента параметра v = " + value);
        } catch (Exception e) { // наслучай попыток передачи неправильных параметров
            System.err.println("Один или несколько параметров не соотвествуют документации, прочтите справку:");
            // и просто выводим справку
            jc.usage();
        }
    }
}
