/**
 * Задание 2 из домашней работы
 *
 * @author : Хильченко А.Н
 * @project : Collections
 * @date : 06.12.2021
 * @comments :
 *     2 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
 *       телефонных номеров. В этот телефонный справочник с помощью метода add() можно
 *       добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
 *       учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 *       тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять
 *       лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
 *       через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
 *       справочника.
 *
 */

import java.util.ArrayList;

class PhoneRecord{
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


public class HW2 {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
            // поскольку параметры у нас ограничены одним классом то их можно не указывать и просто работать с классом
        pb.add("Иванов","84262260011");
        pb.add("Петров","84262220011");
        pb.add("Иванов","84262260022");
        pb.add("Сидоров","84262260023");
        System.out.println("Телефонная книга : "+pb);
        System.out.println("Совпадения для «Иванов» : "+pb.get("Иванов"));

    }
}

/**
 вывод :
 Телефонная книга : [Иванов :  84262260011, Петров :  84262220011, Иванов :  84262260022, Сидоров :  84262260023]
 Совпадения для «Иванов» : [Иванов :  84262260011, Иванов :  84262260022]
 */
