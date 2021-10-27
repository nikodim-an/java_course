/**
 * Домашняя работа №7
 * «Задача о котах и тарелках»
 *
 * @author : Хильченко А.Н
 * @version : 27.10.2021
 */

/*
Формулировка азадачи:
    Программа должна уметь создавать котов и тарелки с едой. В тарелке Имеется какое-то количество еды.
    Кот должен кушать из тарелок еду, в соответсвии со свтоим аппетитом.
Расшитить задачу следующим образом:
    1. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
    (например, в миске 10 еды, а кот пытается покушать 15-20).
    2. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
    удалось покушать (хватило еды), сытость = true.
    3. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
    наполовину сыт (это сделано для упрощения логики программы).
    4. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
    потом вывести информацию о сытости котов в консоль.
    5. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
*/


public class HomeWork7 {

    public static void main(String[] args) {
        // коты
        Cat[] catArray = {new Cat("«Скорый»", 5), new Cat("«Быстрый»", 7), new Cat("«Обделенный»", 4), new Cat("«Экономный»", 3)}; // назвал как корабли, но чтото фантазии на их имена не хватило
        for (Cat i: catArray) {
            System.out.println(i);      //  перечень котов общей нормой питания 16 единиц
        }

        // тарелка
        Plate plate = new Plate(15);
        System.out.println(plate);      //  всегов тарелке 15 единиц еды

        // кормление котов
        for (int i=0; i<catArray.length; i++){
            catArray[i].eat(plate);     // покормили всех котов, кому хватило еды - поел в порядке очередности приема пищи...
                                        // в данности кот по кличке «Обделенный» остался голодным
        }
        System.out.println(plate);      //  остаток еды в тарелке (0)
        plate.addFood(10);              // добавили еды так, чтобы после после комления последнего кота в ней чтото осталось
        for (int i=0; i<catArray.length; i++){
            catArray[i].eat(plate);     // покормили всех котов в порядке очередности, но питаются только голодные
                                        // питался только кот по кличке «Обделенный»
        }

        // отчет по состоянию котов и тарелки
        for (Cat i: catArray) {
            System.out.println(i);
        }
        System.out.println(plate);
    }
}

class Cat {
    private String name;        // имя
    private int appetite;       // аппетит
    private boolean satiety;    // сытоть

    Cat(String name, int appetite){
        this.name= name;
        this.appetite = appetite;
        this.satiety =false;
    }

    @Override
    public String toString(){
        return "Кот "+name+", аппетит - "+appetite+" единиц. " + (satiety==true? "Сейчас сыт.":"Сейчас голоден.");
    }

    public void eat(Plate plate) {        // норма разового питания кота равна аппетиту
        if (this.satiety) {               // кот не питается
            System.out.println("    Кот "+this.name+" от еды отказался");
            return;
        }
        if (plate.decreaseFood(this.appetite)) {
            this.satiety = true;
            System.out.println("    кот "+this.name+" поел и стал сыт");
        } else {
            System.out.println("    ! В тарелке не хватает еды для питания кота "+this.name);
        }
    }

}

class Plate{
    private int food;                 // количесвто еды

    Plate(int capacity){
        this.food = capacity; // предполагается, что тарелка создается полной и безразмерной
    }

    @Override
    public String toString(){
        return "В тарелке "+food+" единиц еды";
    }

    public void addFood(int food){
        this.food+=food;
    }

    public boolean decreaseFood(int volume){
        if (this.food>=volume) {
            this.food-=volume;
            return true;
        } else {
            return false;
        }
    }


}
