/**
 * Домашняя работа №5
 *
 * @author : Хильченко А.Н
 * @version : 1, от 16.10.2021
 */

/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в
консоль.
4. Создать массив из 5 сотрудников.
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312",
30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);
5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
*/

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

class Person {
    // поля оставлю приватными а значение возраста буду получать через геттер.
    private String fullName;
    private String post;
    private String mail;
    private String phone;
    private String salary;
    private String age;

    Person(String fullName, String post, String mail, String phone, String salary, String age) {
        this.fullName = fullName;
        this.post = post;
        this.mail = mail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void print() {
        System.out.println("Сотрудник : \n\t"
                + fullName + ", "
                + post + ", "
                + age + " лет"
                + "\nКонтакты : \n\tпочта: "
                + mail + "\n\tтелефон :"
                + phone + "\nЗаработная плата — " + salary + " денежек");
    }

    public int getAge() {
        return Integer.valueOf(age);
    }
}

public class HomeWork5 {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Иванов Иван Иванович", "дворник", "иванов@почта.рус", "8 800 999 0001", "1000", "45");
        persArray[1] = new Person("Петров Петр Петрович", "помощник дворника", "петров@почта.рус", "8 800 999 0002", "890", "28");
        persArray[2] = new Person("Денисов Денис Денисович", "сантехник", "денисов@почта.рус", "8 800 999 0003", "1500", "37");
        persArray[3] = new Person("Афонасьев Афонасий Афонасьевич", "бухгалтер", "афонасьев@почта.рус", "8 800 999 0004", "1800", "54");
        persArray[4] = new Person("Семенов Семен Семенович", "охранник", "семенов@почта.рус", "8 800 999 0005", "1200", "32");

        for (Person i : persArray) {
            if (i.getAge() > 40) {
                i.print();
                System.out.println("————————————————————————————————————————————————————————————————");
            }
        }
    }

}
