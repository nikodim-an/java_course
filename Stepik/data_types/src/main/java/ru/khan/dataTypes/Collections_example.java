package ru.khan.dataTypes;
import java.util.ArrayList;
/**
коллекции
*/
public class Collections_example {
    // список
    public static void coollections () {
        // список
        ArrayList list = new ArrayList();
        list.add("мама");
        list.add("мыла");
        list.add(3);
        System.out.println(list); // [мама, мыла]
        for(Object element : list) {
            System.out.println(element); // вывел все элементы друг за другом
        }
    }

}
