import ru.khan.classes.Things;

public class Starter {
    public static void main(String[] args) {
        Things knife = new Things("Нож кухонный", "режущий кухонный инструмент", 0.075);
        Things bottle= new Things("Бутылка", "носимый инвентарь", 0.10);
        System.out.println(knife.getDetails());
        Tools pen = new Tools("Карандаш");
        System.out.println(pen.getDetails());
        System.out.println("Всего вещей - "+pen.getCount()); // сколько всего вещей (из things), включая с Tools
        System.out.println("Карандашей в коробке - " +pen.complect.colCount);
    }
}

class Tools extends Things {
    public Complect complect;

    protected class Complect{ // вложенный класс
        public int colCount;

        public Complect(int n) {
            this.colCount = n;
        }
    }

    public Tools (String name){
        this.name = name;
        this.complect = new Complect(10); // это штук в комплекте
    }
}