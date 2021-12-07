import java.util.HashMap;
import java.util.TreeMap;

/**
 * Класс Maps
 *      Примеры использования мапов - по русски справочников, в которых хранится информация парами Ключ-Значение
 * @author : Хильченко А.Н
 * @project : Lists.java
 * @date : 07.12.2021
 * @comments :
 */


public class Maps {
    // HashMap - это простой српавочник, без сортировки
    // LinkedHashMap - это история не на основе массива
    // TreeMap - это упорядоченный по возрастанию HashMap
    // SortedMap - это сортированный вскоразно HashMap

    public static void main(String[] args) {
// простой неупорядоченный HashMap
        HashMap<Integer, String> myMap = new HashMap<>();
        myMap.put(1,"Один");
        myMap.put(2, "Два");
        myMap.put(333, "Триста тридцать три!");
        myMap.put(3, "Три");
        myMap.put(111, "сто одинадцать");
        // вывод
        System.out.println(myMap);
        // перебор
            // способов несколько - это самый понятный (другой через тератор, третий - через entrySet)
            // есть еще встроенный итератор - forEach
        for (int i:myMap.keySet()){
            // Получили множество ключей и перебираем их (ведь список их может быть негладким и с разрывами)
            System.out.println("Ключ - "+i+" : "+myMap.get(i));
            // этот способ дает возможность просто получить доступ как к лючу, так и к значению
            // но он не упорядочивает список
        }
        // перебор встроенным forEach
        myMap.forEach((key, value) -> System.out.println("Ключ - "+key+", значение - "+value));
        // лямбда функция, в которой аргументы из цикла подставляются в вывод

        // получение значения по ключу
        System.out.println(myMap.get(333));
        // запись значения по ключу
        myMap.replace(333, "Новое число");
        System.out.println(myMap.get(333));
        // запись в несуществующую ячейку
        myMap.replace(444, "Новое число 444");
        System.out.println(myMap.get(444));
            // ключ ранее должен быть добавлен, иначе выдаст null
        // удаление пары из справочника
        myMap.remove(333);  // удаляет по ключу
        System.out.println(myMap.get(333));
        System.out.println("-------------------------------------------------------------------");


// теперь упорядоченный справочник treeMap
        TreeMap<Integer, String> myMap1 = new TreeMap<>();
        myMap1.put(1,"Один");
        myMap1.put(2, "Два");
        myMap1.put(333, "Триста тридцать три!");
        myMap1.put(3, "Три");
        myMap1.put(111, "сто одинадцать");
        // вывод
        System.out.println(myMap1);

        // перебор
        // способов несколько - это самый понятный (другой через тератор, третий - через entrySet, еще есть через
        // forEach)
        for (int i:myMap1.keySet()){
            // Получили множество ключей и перебираем их (ведь список их может быть негладким и с разрывами)
            System.out.println("Ключ - "+i+" : "+myMap1.get(i));
            // этот способ дает возможность просто получить доступ как к лючу, так и к значению
                // вывод упорядоченного списка - упорядочен!!!
        }
        // перебор встроенным forEach
        myMap1.forEach((key, value) -> System.out.println("Ключ - "+key+", значение - "+value));
            // лямбда функция, в которой аргументы из цикла подставляются в вывод
            // вывод упорядоченного справочника- упорядочен

        // получение значения по ключу
        System.out.println(myMap1.get(333));
        // запись значения по ключу
        myMap1.replace(333, "Новое число");
        System.out.println(myMap1.get(333));
        // запись в несуществующую ячейку
        myMap1.replace(444, "Новое число 444");
        System.out.println(myMap1.get(444));
        // ключ ранее должен быть добавлен, иначе выдаст null
        // удаление пары из справочника
        myMap1.remove(333);  // удаляет по ключу
        System.out.println(myMap1.get(333));



    }

}
