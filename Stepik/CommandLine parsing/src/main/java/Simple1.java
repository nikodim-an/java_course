/**
 * Класс Simple1
 *
 * @author : Хильченко А.Н
 * @project : CommandLine parsing
 * @date : 29.12.2021
 * @comments :
 */

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.*;

public class Simple1 {
    @Parameter(names = "-v",description = "переданное значение")
    private Integer value = 333; // это то что будет по умолчанию, если не будет такого параметра

    @Parameter(names = "--help", help = true)
        // указано умолчание если параметр встретился,
        // это нужно чтобы написать только параметр не указывая его значение - как это делается с командами
    private boolean help;

    public static void main(String[] args) {
        Simple1 app = new Simple1();
            // получили ссылку на процесс
        JCommander.newBuilder()
                .addObject(app)
                .build()
                .parse(args);
            // распарсили параметры через streamAPI
        // параметры распарсены и установлены, теперь можно реально запустить программу
        app.run();

    }

    public void run() {
        // а это запуск программы по установленным параметрам
        if (help == true) System.out.println("Если нужна только ручная справка");
        System.out.println("Стартовое значение аргумента параметра v = "+value);
        
    }
}
