import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Класс Sets
 *
 * @author : Хильченко А.Н
 * @project : Lists.java
 * @date : 07.12.2021
 * @comments :
 */


public class Sets {
    // HashSet, - простое неупорядоченное множество на основе массива
    // LinkedHashSet - простое множество не на основе массива (а на основе linkedList)
    // TreeSet - Объекты сохраняются в отсортированном порядке по возрастанию, с быстрым временем доступа.

    public static void main(String[] args) {
        Integer[] i = {1,22,5,4,5,6,7,8};

        HashSet set = new HashSet(Arrays.asList(i)); // множество на основе массива
        System.out.println(set);                     // clipboard : [1, 4, 5, 22, 6, 7, 8] 

        TreeSet set1= new TreeSet(Arrays.asList(i)); // сортированное множество на основе несортированного массива
        set1.add((Object) 3);                         // добавил число как объект
        System.out.println(set1);                    // clipboard : [1, 4, 5, 22, 6, 7, 8]
            // сортировка на лицо

        // перебор как и в списках, добавление, удаление, и так далее... множество и множество. Оно интересно в
        // первую очередь тем что его можно создать на основе коллекции (в частности списка)

    }
}
