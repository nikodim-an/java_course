package controller; /**
 * Класс OneTableController
 *
 * @author : Хильченко А.Н
 * @project : SQLiteExample
 * @date : 22.12.2021
 * @comments :
 */

import model.Student;
import org.sqlite.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class OneTableController {
    private final String PATH_TO_DB = "jdbc:sqlite:src/main/resources/students.db";
    // тут вместо пути относительно папки проекта можно указать IP и порт на котором крутится БД
    private Connection connection;

    // Подключение делается в конструкторе! тоесть как только создался экземпляр класса - он сразу подключен.


    public OneTableController()  throws SQLException{
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(PATH_TO_DB);
    }

    public void add (Student student){
        // добввим студента в базу данных
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                "INSERT INTO persons('name','age','group','cource') VALUES (?,?,?,?)"
        )) {
            preparedStatement.setObject(1, student.getName());
            preparedStatement.setObject(2, student.getAge());
            preparedStatement.setObject(3, student.getGroup());
            preparedStatement.setObject(4, student.getCource());
            preparedStatement.execute();
            System.out.println("\tСтудент добавился…");
        } catch (Exception e) {
            System.out.println(e);
        }        
    }
    
    public void addTable() {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                " CREATE TABLE `personsAdded` (\n" +
                        "`name`\tTEXT,\n" +
                        " `age`\tINTEGER,\n" +
                        " `group`\tINTEGER,\n" +
                        " `cource`\tINTEGER\n" +
                        ");"
        )) {
            preparedStatement.execute();
            System.out.println("\tТаблица добавилась");
        } catch (Exception e) {
            System.out.println(e);
        }
            
    }
}
