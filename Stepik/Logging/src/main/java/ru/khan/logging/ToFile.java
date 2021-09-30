package ru.khan.logging;

import java.util.logging.*;
import java.io.IOException;

public class ToFile {
    static String message = "сообщение про сообщение в файле";
    public static void main() {
        System.out.println("————————————————————————————————————— вывод логером в консоль и файл");
        // Создать регистратор
        Logger logger = Logger.getLogger("Логгер в файл");
        try {
            //FileHandler fileHandler = new FileHandler("/home/alex/DeskTop/log.log", 5 * 1024 * 1024, 5); // пишет в несколько файлов и по достижении максимального размера начинает новый с новым номером
            FileHandler fileHandler = new FileHandler("/home/alex/DeskTop/log.log");
            fileHandler.setFormatter(new SimpleFormatter()); // форматтер
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (Exception e) {
            System.err.println("Failed to configure logging to file");
        }
        logger.info("Информационное сообщение : "+message); // сообщение по уровню логирования info
        logger.severe("сообщение по уровню \"Строго\""); // сообщение по уровню "Строго"
        logger.warning("сообщение по уровню \"Внимание\""); // сообщение по уровню "Внимание"
        logger.config("Сообщение о конфигурации");
        logger.fine("Fine"); // сравнительные степени «все сногисшибательно»
        logger.finer("finner");
        logger.finest("finest");

    }
}

/*
* сообщение будет иметь вид
* <record>
  <date>2021-09-30T08:41:50.057666Z</date>
  <millis>1632991310057</millis>
  <nanos>666000</nanos>
  <sequence>3</sequence>
  <logger>Логгер в файл</logger>
  <level>INFO</level>
  <class>ru.khan.logging.ToFile</class>
  <method>main</method>
  <thread>1</thread>
  <message>Информационное сообщение : сообщение про сообщение в файле</message>
</record>
* если включить форматер - а в конслои он SimpleFormatter, то сообщения будут выглядеть как в консоли.
*
* */
