import java.util.Arrays;

/**
 * Стенд по теме «Обобщения»
 *
 * @author : Хильченко А.Н
 * @project : homework 3
 * @date : 04.12.2021
 * @comments : чето вообще ничего не понятно…
 *
 */

class MyObj {
    // класс хорянящий объект любого типа и возвращающий его без использования обобщений
    Object object;

    public MyObj(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}

class MyGenObj<T> {
    // обобщенный класс с одним параметром типа
    T object;

    public MyGenObj(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}

class Box<T, E> {
    T obj1;
    E obj2;

    public Box(T obj1, E obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public String toString() {
        return "Box{" +
                "obj1=" + obj1.toString() + ", obj2=" + obj2.toString() +
                '}';
    }
}

class ArrayBox<T>{
    T[] obj;

    public ArrayBox(T... obj) {
        this.obj = obj;
    }

    public void add(int index, T value){
        this.obj[index] = value;
    }

    @Override
    public String toString() {
        return "ArrayBox{" +
                "obj=" + Arrays.toString(obj) +
                '}';
    }
}

/*
Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 */
class ChangedBox<T>{
    private T[] obj;

    public ChangedBox(T... obj) {
        this.obj = obj;
    }

    public void excahge(int i, int j){
        T value = obj[i];
        obj[i] = obj[j];
        obj[j] = value;
    }


    @Override
    public String toString() {
        return "ChengedBox {" +
                "obj=" + Arrays.toString(obj) +
                '}';
    }
}

/*
   Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
   Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
   Для хранения фруктов внутри коробки можно использовать ArrayList;
   Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
   Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
   Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
   Не забываем про метод добавления фрукта в коробку.
*/



public class stend {
    public static void main(String[] args) {
        // работа с классом на основе object
        System.out.println("————Работа с простым классом без обобщения————————————————");
        String s = "Мама мыла раму… (!)";
        MyObj obj = new MyObj(s);
        System.out.println(obj.getObject());
            // не матюгается потому что в него засылается и извлекается тип-наследник obj
        Integer i = 333;
        MyObj obj1 = new MyObj(i);
        System.out.println(obj1.getObject());
            // таким образом создается хранилище одного объекта неизвестного типа без дженериков

        System.out.println("————Обобщенный класс с одним параметром———————————————————");
        // теперь работа с дженериком
        MyGenObj<String> genObj = new MyGenObj<String>(s);
            // в правой части тип можно не указывать
        System.out.println(genObj.getObject());
        MyGenObj<Integer> intObj = new MyGenObj<>(i);
        System.out.println(intObj.getObject());
            // вроде как тоже самое, но при использовании полученного значения не придется проверять его тип - он
            // будет ТОЛЬКО тем, что задан в <> скобках

        System.out.println("————Обобщенный класс с двумя параметрами——————————————————");
        // обобщенный класс с двумя параметрами
        Box<Integer, String> box = new Box<>(i, s);
        System.out.println(box);
        Box<String, Integer> box1 = new Box<>(s, i);
        System.out.println(box1);

        System.out.println("————Работа с массивами————————————————————————————————————");
        ArrayBox<Integer> box2= new ArrayBox<>(10,9,8,7,6,5,4,3,2,1,0,333333,444444,55555);
        System.out.println(box2);
        box2.add(5,555);
        box2.add(6,666);
        box2.add(9,999);
        System.out.println(box2);

        System.out.println("———— Задание 1 из домашки —————————————————————————————————");
        ChangedBox<Integer> myBox1 = new ChangedBox<>(10,9,8,7,6,5,4,3,2,1,0);
        System.out.println(myBox1);
        myBox1.excahge(0,10);
        System.out.println(myBox1);

        ChangedBox<String> myBox2 = new ChangedBox<>("10","9","8","7","6","Привет!","4","3","2","1","0");
        System.out.println(myBox2);
        myBox2.excahge(0,10);
        System.out.println(myBox2);

        System.out.println("———— Ограниченные типы —————————————————————————————————");



    }
}
