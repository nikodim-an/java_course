/**
 * класс Person
 * часть домашнего задания №4 (пункты 1-3)
 *
 * @author : Хильченко А.Н
 * @version : 19.10.2021
 */

// комменарии в коде относятся только к коду, логика действий изложена в readme.md каталога репозитория с домашним заданием

class Person {
    // поля делаю приватными а значение возраста буду получать через геттер.
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

    /*
    поскольку в этом задании ясно сказано, что метод должен ВЫВОДИТЬ на экран данные о сотруднике, а не возвращать их
    в виде строки, то это точно не случай с переопределением метода toString, а значит логично будет и назвать метод «print» …
    а преобразование класса в строку - сделать там, где это положено - т.е в методе toString
    */
    public void print() {
        System.out.println(this);
    }

    public String toString() {
        // в данном случае переопределение позволит мне вывести данные так, как это нужно
        // (в одну строку или в несколько)
        return ("Сотрудник : \n\t"
                + fullName + ", " + post + ", " + age + " лет"
                + "\nКонтакты : \n\tпочта: " + mail
                + "\n\tтелефон :" + phone
                + "\nЗаработная плата — " + salary + " каких-то денег");
    }

    public int getAge() {
        return Integer.valueOf(age);
    }

}
