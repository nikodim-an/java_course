/**
 * Домашняя работа №6
 *
 * @author : Хильченко А.Н
 * @version : 22.10.21
 */


interface AnimalsAction {
    void doRun(int distance);
    void doSwim(int distance);
    String getVoice();
}

abstract class Animals implements AnimalsAction {
    protected String name;
    protected int maxRun;
    protected int maxSwim;
    protected String voice;
    static int animalsCount = 0;

    Animals(String name, String voice, int maxRun, int maxSwim) {
        this.name    = name;
        this.voice   = voice;
        this.maxRun  = maxRun;
        this.maxSwim = maxSwim;
        animalsCount++;
    }

    public String getVoice() {
        return voice;
    }

    public void doRun(int distance) {
        if (distance<=0) { // задом и наместе не бегает
            return;
        } else if (maxRun == 0) { // не бегает вообще
            System.out.println("«"+name +"» бегать не умеет");
        } else if (distance>maxRun) { // так далеко не бегает
            System.out.println("«"+name +"» не бегает больше чем на "+maxRun+" метров…");
        } else { // пробежал
            System.out.println("«" + name + "» пробежал " + distance + " метров");
        }
    }

    public void doSwim(int distance) {
        if (distance<=0) { // задом и наместе зверь не плавает
            return;
        } else if (maxSwim == 0) { // не плавает вообще
            System.out.println("«"+name +"» плавать вообще не умеет");
        } else if (distance>maxSwim) { // так далеко не плавает
            System.out.println("«"+name +"» не плавает больше чем на "+maxSwim+" метров…");
        } else { // проплыл
            System.out.println("«" + name + "» проплыл " + distance + " метров");
        }
    }

}

class Cat extends Animals {

    Cat(String name) {
        super(name, "МЯУ!", 200, 0);
    }

    @Override
    public String toString() {
        return "Кот по имени «" + name + "»:\n"
                + "\t бегает - не более " + maxRun + " метров,\n"
                + "\t плавать не умеет,\n"
                + "\t издает звуки - «" + voice + "»";
    }
}

class Dog extends Animals {

    Dog(String name) {
        super(name, "ГАВ!", 500, 10);
    }

    @Override
    public String toString() {
        return "Пёс по имени " + name + ":\n"
                + "\t бегает - не более " + maxRun + " метров,\n"
                + "\t плавает - не более " + maxSwim + " метров,\n"
                + "\t издает звуки - «" + voice + "»";
    }
}

public class HomeWork6 {

    public static void main(String[] args) {
        Cat cat = new Cat("Барсик");
        Dog dog = new Dog("Тузик");

        System.out.println(cat);
        System.out.println(dog);
        System.out.println();
        dog.doRun(-50);
        dog.doRun(0);
        dog.doRun(150);
        dog.doRun(700);
        dog.doSwim(10);
        dog.doSwim(50);
        cat.doRun(199);
        cat.doRun(201);
        cat.doSwim(50);
        System.out.println();

        Dog dog2 = new Dog("Шарик"); // добавим шарика до кучи… после этого зверей должно стать трое
        System.out.println("Всего зверей - "+Animals.animalsCount );



    }

}
