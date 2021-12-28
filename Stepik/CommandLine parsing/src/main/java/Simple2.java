/**
 * Класс Simple2
 *
 * @author : Хильченко А.Н
 * @project : CommandLine parsing
 * @date : 29.12.2021
 * @comments :
 */

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.*;

public class Simple2 {
    @Parameter(names = "-v",description = "переданное снаружи значение")
    private static Integer value = 333; // это то что будет по умолчанию, если не будет такого параметра

    @Parameter(names = {"--help","?","-h"}, help = true, description = "Справка")
    // указано умолчание если параметр встретился,
    // это нужно чтобы написать только параметр не указывая его значение - как это делается с командами
    private static boolean help;

    public static void main(String[] args) {
        Simple2 app = new Simple2(); // экземпляр запускаемого класса.
            // по-моему это костыль, но он пришел из документации
        JCommander jc = new JCommander();
        jc.addObject(app);
        jc.setProgramName("ИМЯ ПРОГРАММЫ"); // 17 и 18 пункты справки разработчика
        jc.parse(args);
            // теперь параметры распарсены и их значения внесены в нужные преременные
        if (help == true) jc.usage(); // выведется справка, сформированная автоматически
        System.out.println("Стартовое значение аргумента параметра v = "+value);
    }


}
