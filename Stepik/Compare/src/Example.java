/**
 * Класс Example
 *
 * @author : Хильченко А.Н
 * @project : Compare
 * @date : 08.12.2021
 * @comments :
 */

import java.util.*;

// Comparable - Интерфейс дял сравнения внутри коллекции (через if сравнить не получится)
// Comparator - Интерфейс дял сравнения элементов один на один (через if a>b …)


class Element implements Comparable{
    Integer value;
    String description;

    public Element(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return "(" + description + ':'+ value + ')';
    }

    /*
    В интерфейсе Comparable описан метод compareTo(Object o), который отвечает за сравнение
    объектов нашего класса. Если метод compareTo() вернет положительное число, значит текущий
    объект (this) больше o, если отрицательное - this меньше o, если вернул 0, значит объекты равны
    между собой. Указанную выше реализацию метода compareTo можно сократить до:
     */


    @Override
    public int compareTo(Object o) {
        Element eo = (Element) o;
        if (this.value<eo.value) {
            return 1;
        } else if (this.value==eo.value){
            return 0;
        } else {
            return -1;
        }
    }

}


public class Example {
    public static void main(String[] args) {
        Element e1 = new Element(1, "Первый");
        Element e2 = new Element(2, "Второй");
            // первый больше чем второй
        TreeSet<Element> set = new TreeSet<>();
        set.add(e2);
        set.add(e1);
        set.add(new Element(10, "Десятый"));
        set.add(new Element(0,"Нулевой"));
        System.out.println(set);
            // упорядочивание на лицо [(Десятый:10), (Второй:2), (Первый:1), (Нулевой:0)]

    }
}
