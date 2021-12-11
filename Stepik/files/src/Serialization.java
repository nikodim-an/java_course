/**
 * Класс Serialization
 *
 * @author : Хильченко А.Н
 * @project : files
 * @date : 11.12.2021
 * @comments :
 */

import java.io.*;
import java.util.*;

class Person implements Serializable {
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


public class Serialization {
    final static String path = "file.dat";

    public static void main(String[] args) {
        Person vasya = new Person("Вася", 33);
        Person fedya = new Person("федя",22);

        // Сохраним объекты в файл
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(path))){
            writer.writeObject(vasya);
            writer.writeObject(fedya);
        } catch (Exception e) {
            System.err.println(e);
        }

        // Прочтем объекты из файла
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(path))) {
            System.out.println((Person) reader.readObject());  // это вася
            System.out.println((Person) reader.readObject());  // это федя
            // их там два
        } catch (Exception e) {
            System.err.println(e);
        }

    }





}
