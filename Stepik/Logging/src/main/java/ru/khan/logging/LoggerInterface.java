package ru.khan.logging;

import java.lang.System.*;
/*
Для вывода логов есть специальный интерфейс system.logger,
который использует loggerFinder, который использует java.utils.logging … нахрена козе баян...
к томуже и неудобный.
*/

public class LoggerInterface {

    public static void main(){
        // Использование system.logger дял логирования
        System.out.println("————————————————————————————————————— вывод через system.logger");
        System.Logger logger = System.getLogger("Логгер от System");
        logger.log(Logger.Level.INFO, "Это есть запись в лог, да-да…");
        logger.log(Logger.Level.DEBUG, "ALL, да-да…"); // это в консоль не выводится.
        logger.log(Logger.Level.WARNING, "Это есть запись в лог, да-да…");
        logger.log(Logger.Level.ERROR, "Это есть запись в лог, да-да…"); // а это на самом деле severe
        }
}
