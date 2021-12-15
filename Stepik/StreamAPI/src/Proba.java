/**
 * Класс Proba
 *
 * @author : Хильченко А.Н
 * @project : StreamAPI
 * @date : 13.12.2021
 * @comments : Это есть «проба пера» в которой я предварительно разбираюсь (до начала изучения на курсе) темы StreamAPI.
 *      Тут все что удалось понять «сходу», изучив один мануал из многих, но с хабра.
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Proba {
    public static void main(String[] args) {
        // на основе целочисленной коллекции.
        Integer[] arr1 = {1,2,5,4,3,6,9,0,6,7,8,10,3,22,43,2,12,5,56,14};
        // увеличим каждый в двое и выведем
        Arrays.stream(arr1).map(x->x*2).forEach(System.out::println);
        System.out.println("--Сортировка целочисленного массива------------");
        Arrays.stream(arr1).map(x->x*2).sorted().forEach(System.out::println);


        System.out.println("--Поиск в строковом массиве--------------------");
        // на основе строковго массива (и коллекции)
        String[] arr = {"один", "раз", "два", "три", "раз", "два", "раз", "два", "раз", "два", "три", "раз", "два", "три",
                "четыре", "раз", "два","три","четыре","пять"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        list.stream()
                .filter(s->s.startsWith("ра"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("--Простое перечисление элементов потока--------");
        // Поток на основе простого пеерчисления элементов: // хотя какой он в ……… поток... тогда уже конвейер
        Stream.of("раЗ","два","три","раС")
                .filter(s->s.startsWith("ра"))              // я больше просто ничего не умею, пока…
                .map(String::toLowerCase)
                .forEach(s -> System.out.println("forEach: " + s));

        // возврат коллекции из потока
        System.out.println("--Получение результата работы потока в коллекцию--");
        List<String> colList = list.stream()
                .filter(s->s.startsWith("ра"))
                .collect(Collectors.toList()); // для спарвочника - toMap, для множества toSet …
        colList.forEach(System.out::println);
        // можно вернуть и другие коллекции, но это уже несколько геморойно…
        // а более сложные вещи с применением инетрфейса Collectors будут в отдельном файле.

    }

}
