/**
 * Класс GUI
 *
 * @author : Хильченко А.Н
 * @project : SQLiteExample
 * @date : 22.12.2021
 * @comments :
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import controller.*;
import model.Student;

public class GUI {

    public static void oneTableStend() {
        /**
         * работа с одной таблицей
         */
        System.out.println("-- Запись данных в таблицу БД -----------------");
        // подключение к БД
        Student student = new Student("Вася",20,412,4);
        try {
            OneTableController controller = new OneTableController();
            controller.add(student);
            controller.addTable();
        } catch (Exception e) {
            System.out.println(e);
        }

    }



}
