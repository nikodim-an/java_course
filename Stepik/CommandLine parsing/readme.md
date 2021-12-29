# Парсинг аргументов командной строки

## Чем
Парсить буду JCommander он есть в репозитории и по нему есть документашка в md - в корне проекта. кроме того он 
поддерживает самую продвинутую систему парсинга, которая понимает в том числе и команды:
```
Usage: <main class> [options] [command] [command options] 
    Commands:
        log  показывает историю ревизий всего репозитория или файлов
            Usage: log [options]
            Options:
                -l, --limit
                ограничивает количество отображаемых изменений
```
и при этом она умеет потом отдельно спрашивать пароли, никуда их не сохраняя, что может быть весьма удобно.

## Как
Вообще каждый параметр нужно описать как:
```java
    @Parameter(names = "-v",description = "переданное значение")
    private Integer value = 333; // это то что будет по умолчанию, если не будет такого параметра

    @Parameter(names = "--help", help = true)
        // указано умолчание если параметр встретился,
        // это нужно чтобы написать только параметр не указывая его значение - как это делается с командами
    private boolean help;
```
а потом в точке входа использовать конструкцию примерно аналогичную этой:
```java
JCommander.newBuilder()
    .addObject(app)
    .build()
    .parse(args);
```
где app - экземпляр текущего класса имеющего точку входа (который в данный момент запускается).  
Но тот тоже не все атк просто - дальше нужно смотреть на варианты использования библиотеки. Дале я разбиру два 
примера (самого простого использования) а потом на их основе сделаю заготовку базового кода, который потом пойдет в 
создаваемый архетип…

### Самый простой вариант
Непосредственно в теле точки входа.
код в файле `Simple1.java`, но он весьма неудобен поскольку не дает возможности адекватно вывести справку (или я его 
не знаю).

### Более удобный, но менее понятный 
(хотя я хз - вроде тоже понятно)
код в файле `Simple2.java` , но и он не совсем правильный, поскольку не обрабатывется исключение на тему попыток 
пеердачи неизветсных параметров, а значит тут нужно еще немного подумать, хоть вариант и рабочий, а самое главное 
выдает адекватную справку.

### Наиболее правильный, но все еще из числа простых…
тут я уже положу код, хотя он есть в `Simple3` - это чтобы не копаться
```java
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
        // это нужно, чтобы написать только параметр не указывая его значение - как это делается с командами


    public static void main(String[] args) {
        Simple3 app = new Simple3(); // экземпляр запускаемого класса.
            // по-моему это костыль, но он пришел из документации
        JCommander jc = new JCommander();
        jc.addObject(app);
        jc.setProgramName("ИМЯ ПРОГРАММЫ"); // 17 и 18 пункты справки разработчика, нужно для корректного вывода справки
        try {
            jc.parse(args);
                // теперь параметры распарсены и их значения внесены в нужные преременные
            if (help == true) jc.usage();   // выведется справка, сформированная автоматически
            System.out.println("Стартовое значение аргумента параметра v = " + value);
        } catch (Exception e) {             // на случай попыток передачи неправильных параметров
            System.err.println("Один или несколько параметров не соотвествуют документации, прочтите справку:");
            // и просто выводим справку
            jc.usage();
        }
    }
}
```
На этом изыскания можно и закончить, поскольку всего, что меня интересовало я уже и достиг. Более сложные «дебри» 
меня пока не интересуют... хотя тут много всего еще есть. на основе этого кода планирую создать архетип.