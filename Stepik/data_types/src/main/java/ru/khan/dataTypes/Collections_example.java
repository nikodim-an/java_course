package ru.khan.dataTypes;
import java.util.ArrayList; // есть и другие, зависит от задачи
import java.util.HashSet; // есть и другие, зависит от задачи
import java.util.SortedSet; // сортированное множество
import java.util.HashMap;
/**
коллекции
*/
public class Collections_example {
    // список
    public static void coollections () {
        // список
        ArrayList list = new ArrayList();
        list.add("мама");
        list.add("папа");
        list.add(3);
        System.out.println(list); // [мама, мыла]
        // перебор
        for(Object element : list) {
            System.out.println(element); // вывел все элементы друг за другом
        }
        // множество
        HashSet hashSet = new HashSet(); // оно вроде итак сортируется - но: непонятно
        hashSet.add("1");
        hashSet.add("кишка");
        hashSet.add("котенок");
        System.out.println(hashSet.toString()); // [1, кишка, котенок]
        // сортированное множество
        HashSet sortedSet = new HashSet();
        sortedSet.add("кот");
        sortedSet.add("кишка");
        sortedSet.add("1");
        System.out.println(sortedSet.toString()); // [1, кишка, кот]
        // справочник (map) - ЭТО НЕ НАСЛЕДНИК КОЛЛЕКЦИЙ
        HashMap map = new HashMap();
        map.put("спиннинг", "Хитрое удилище с катушкой");
        map.put("махалка","короткое удилище для ловоли на льду");
        System.out.println(map.toString()); // {махалка=короткое удилище для ловоли на льду, спиннинг=Хитрое удилище с катушкой}
        /**
         * классов дял хранения данных - много даже в каждом виде и нужно выбирать тот который больше всего подходит.
         * Поскольку репозиторий делаю дял себя - то мне проще загуглить, поскольку понимаю как это работает и что
         * ожидать от коллекций. ЗА сим прекращаю рисовать тут работу с коллекциями - основное я понял - списки (map) -
         * это обособленный класс, похожий на коллекцию, но не коллекция (не наследуется от коллекций) с остальными
         * коллекциями все ожидаемо - названия классов одинаковые, работать с ними, в основном, по образцу.
         */
    }

}
