import java.util.List;

/**
 * Задание 2
 *
 * @author : Хильченко А.Н
 * @project : homework 3
 * @date : 04.12.2021
 * @comments : Задача:
 *     - Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 *     - Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну
 *     коробку нельзя сложить и яблоки, и апельсины;
 *     - Для хранения фруктов внутри коробки можно использовать ArrayList;
 *    Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 *    Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
 *    Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
 *    Не забываем про метод добавления фрукта в коробку.
 */

class Fruit{ // все фрукты
    int weight;
    public Fruit(int value){
        this.weight = value;
    }
}

class Apple extends Fruit{};    // яблоки
class Orange extends Fruit{};   // апельсины

class Box<T extends Fruit>{     // коробка
    // условимся что коробки безразмерны
    List<T> list = new ArrayList<>();
        // каждый элемент этого списка - партия фруктов одного вида.

    public Box(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Коробка {" + list + "}";
    }

    public void add(T value){
        this.list.add(value);
    }
    public int getWeight(){
        int result = 0;
        for (T i: list) {
            result+=i.weight;
        }
        return result;
    }

}



// точка входа
public class Task2 {

    public Apple createApples(int value){
        Apple apples = new Apple(value);
        return apples;
    }

    public Orange createOranges(int value){
        Orange oranges = new Orange(value);
        return oranges;
    }

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.add(this.createApples(10));
        appleBox.add(this.createApples(6));
        appleBox.add(this.createApples(3));
        appleBox.add(this.createApples(8));
        System.out.println(appleBox);
    }

}
