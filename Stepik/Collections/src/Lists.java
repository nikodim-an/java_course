/**
 * Списки
 *
 * @author : Хильченко А.Н
 * @project : Collections
 * @date : 06.12.2021
 * @comments :
 */

import java.util.*;
import java.util.List;

class myClass {
    // Допустим экземпляр хранит точку с описанием
    String description;
    Integer x;
    Integer y;

    public myClass(String description, Integer x, Integer y) {
        this.description = description;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Точка " + description +
                " (x=" + x +
                ", y=" + y +
                ')';
    }
}

public class Lists {

    public static void main(String[] args) {
        // строковый (числовой и любой ссылочный) список
        ArrayList<String> myStrings = new ArrayList<>();
        System.out.println(myStrings);
        myStrings.add("Папа тулил гвоздь0");
        myStrings.add("Папа тулил гвоздь1");
        myStrings.add("Папа тулил гвоздь2");
        System.out.println(myStrings);

        // список элементов класса
        ArrayList<myClass> myList = new ArrayList<>();
        System.out.println(myList);
        myList.add(new myClass("1",1,0));
        myList.add(new myClass("Два",1,1));
        myList.add(new myClass("ТРИ",1,333));
        System.out.println(myList);

    }
}
