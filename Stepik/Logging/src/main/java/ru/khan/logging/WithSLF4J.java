/**
 * Класс WithSLF4J
 *
 * @author : Хильченко А.Н
 * @project : Logging
 * @date : 06.02.2022
 * @comments :
 */

/*
* Эта хрень вообщето надстройка над логером. Для нормальной работы нужна привязка (bind)
* самая распространенная — slf4j-simple
* но есть также привязка к стандартному java.util.logging.
* ПРИВЯЗКА ДОЛЖНА БЫТЬ ОДНА И ПОДХВАТЫВАЕТСЯ АВТОМАТИЧЕСКИ!!!
* Здесь я работаю с первой. ОБЯЗАТЕЛЬНО ДОЛЖНЫ БЫТЬ ПРОПИСАНЫ ОБA ДЕПЕНДЕНСИСА! один на SLF4J, второй на SimpleLogger
* Для ее настройки нужен файл в ресурсах simplelogger.properties
* Последовательность возможных уровней логирования - "trace", "debug", "info", "warn", "error"
* выводить одновременно на экран и в файл - НЕ УМЕЕТ! Дл яэтого нужно воспользоваться другой привязкой
*/

package ru.khan.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.SimpleLogger;

import java.util.*;


public class WithSLF4J {

    public static void foo() {
        Logger logger = LoggerFactory.getLogger("MyLogger");
        // "trace", "debug", "info", "warn", "error"
        logger.trace("Трассировка");
        logger.debug("Отладка");
        logger.info("Событие");
        logger.warn("Внимание");
        logger.error("Ошибка");

        Logger logger1 = LoggerFactory.getLogger(WithSLF4J.class);
        logger1.trace("Трассировка");


    }

}
/*
* Вывод:
2022-02-06 19:01:44:358 [main] TRACE MyLogger - Трассировка
2022-02-06 19:01:44:362 [main] DEBUG MyLogger - Отладка
2022-02-06 19:01:44:371 [main] INFO MyLogger - Событие
2022-02-06 19:01:44:371 [main] WARN MyLogger - Внимание
2022-02-06 19:01:44:371 [main] ERROR MyLogger - Ошибка
2022-02-06 19:01:44:371 [main] TRACE ru.khan.logging.WithSLF4J - Трассировка

*/