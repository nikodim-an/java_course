/**
 * Домашняя работа №4 «Коллекции»
 *
 * @author : Хильченко А.Н
 * @project : homework4
 * @date : 06.12.2021
 * @comments :
 * Задания:
 *    1 Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
 *      вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 *      Посчитать, сколько раз встречается каждое слово.
 *    2 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
 *      телефонных номеров. В этот телефонный справочник с помощью метода add() можно
 *      добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
 *      учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 *      тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять
 *      лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
 *      через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
 *      справочника.
 *
 */

import java.util.*;
//import java.util.ArrayList;

class PhoneRecord{
    // класс записи в телефонную книгу (одна позиция)
    String surname;
    String phoneNumber;

    public PhoneRecord(String surname, String phoneNumber) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return surname +" :  " + phoneNumber;
    }
}

class PhoneBook<T extends PhoneRecord> extends ArrayList {
    // Класс телефонной книги, хранящий записи и наследованный от ArrayList - он по определению сразу коллекция

    public PhoneBook(){
        super();
    }

    public void add(String surname, String phoneNumber){
        this.add(new PhoneRecord(surname, phoneNumber));
    }

    public ArrayList get(String surname){
        ArrayList<T> res = new ArrayList<>();
        for (int i=0; i<this.size(); i++){
            T record = (T) this.get(i);
            if (surname.equals(record.surname)){
                res.add(record);
            }
        }
        return res;
    }

}



public class Main {

    public static void main(String[] args) {
        // Задание 1
        String[] words = {"один", "раз", "два", "три", "раз", "два", "раз", "два", "раз", "два", "три",
                "раз", "два", "три", "четыре", "раз", "два","три","четыре","пять"};
            // 20 слов, 15 уникальных
        System.out.println("Иcходный массив : "+Arrays.toString(words)+" всего элементов —"+words.length);
        HashSet set = new HashSet(Arrays.asList(words)); // если нужно сразу коллекцию массив заполненной
        System.out.println("Список уникальных слов : " + set+" всего элементов —"+set.size());
        HashMap<String, Integer> frequency = new HashMap<>();
        for (String i:words){
            frequency.put(i, Collections.frequency(Arrays.asList(words),i));
        }
        System.out.println("Подсчет вхождений : "+frequency+"\n");

        // Задание 2
        PhoneBook pb = new PhoneBook();
        // поскольку параметры у нас ограничены одним классом, то класс можно не параметризовать
        // и просто работать с ним как с обычным
        pb.add("Иванов","84262260011");
        pb.add("Петров","84262220011");
        pb.add("Иванов","84262260022");
        pb.add("Сидоров","84262260023");
        System.out.println("Телефонная книга : "+pb);                       // вся телефонная книга
        System.out.println("Совпадения для «Иванов» : "+pb.get("Иванов"));  // найденные Ивановы

    }

}
