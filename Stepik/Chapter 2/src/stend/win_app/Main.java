package stend.win_app;

/**
 * это главный класс
 */
public class Main {
    /**
     * Простой статический класс
     */
    public static class Tool{
        // класс «инструмент»
        protected String name; // наименование
        protected String purpose; // назначение
        protected double weight; // вес в килограммах
        public Tool (String name, String purpose, double weight) {
            // проверку адекватности данных не устраиваю…
            this.name = name;
            this.purpose = purpose;
            this.weight = weight;
        }
        public final String getDescription() {
            String res = this.name+", "+this.purpose+", "+this.weight+" килограмм"+ " - вывод статического класса";
            return res;
        }
    }

    /**
     * Нестатический класс
     */
    public class Tool1{
        // класс «инструмент»
        protected String name; // наименование
        protected String purpose; // назначение
        protected double weight; // вес в килограммах
        public Tool1 (String name, String purpose, double weight) {
            // проверку адекватности данных не устраиваю…
            this.name = name;
            this.purpose = purpose;
            this.weight = weight;
        }
        public final String getDescription() {
            String res = this.name+", "+this.purpose+", "+this.weight+" килограмм"+ " - вывод нестатического класса";
            return res;
        }
    }

    public static void main(String[] args) {
        // создание объекта статического класса
        Tool knife;
        knife = new Tool("Нож поварской", "Нужен для работы на кухне - резать и крошить", 0.070);
        // создание объекта несатического класса
        Main m = new Main();
        Main.Tool1 knife1 = m.new Tool1("Нож поварской", "Нужен для работы на кухне - резать и крошить", 0.070);

        // Вывод созданных объектов
        System.out.println(knife.getDescription());
        System.out.println(knife1.getDescription());

    }

}


