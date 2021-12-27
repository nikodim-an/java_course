package model; /**
 * Класс Student
 *
 * @author : Хильченко А.Н
 * @project : SQLiteExample
 * @date : 22.12.2021
 * @comments :
 */

import java.util.*;

public class Student {
    /* таблица создавалась так:
    CREATE TABLE `persons` (
	`name`	TEXT,
	`age`	INTEGER,
	`group`	INTEGER,
	`cource`	INTEGER
    );
     */
    String name;
    Integer age;
    Integer group;
    Integer cource;

    Student(){
        super();
    }

    public Student(String name, Integer age, Integer group, Integer cource) {
        // Этот конструктор нужен дял создания объекта при чтении из БД.
        this.name = name;
        this.age = age;
        this.group = group;
        this.cource = cource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getCource() {
        return cource;
    }

    public void setCource(Integer cource) {
        this.cource = cource;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", group=" + group +
                ", cource=" + cource +
                '}';
    }
}
