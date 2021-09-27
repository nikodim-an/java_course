package ru.khan.dataTypes;
import java.util.Arrays;

public class Enumerators {
    public static enum Season { WINTER, SPRING, SUMMER, AUTUMN }

    public static enum MyDayOfWeek { // подобный енумератор есть в java.time
        MONDAY,
        TUESDEY,
        WIDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
    //пример пеерчисления со встренными методами
    public static enum Urgency {
        HIGH {
            public String perfomance() {return "Срочно";}
        },
        MEDIUM {
            public String perfomance() {return "Не срочно";}
        },
        LOW {
            public String perfomance() {return "Можно потом";}
        };

        public abstract String perfomance();
    }

    public static void enumerateUse (){
        /*
        перечисление - это класс!
        values() - возвращает массив возможных значений перечислений в порядке их ввода.
        name() - возвращает имя элемента перечисления (как в исходном коде)
        ordinal() - возвращает число (порядковы й номер), начиная с 0 (индекс короче)
         */
        System.out.println(MyDayOfWeek.values()[1]); //TUESDEY
        System.out.println(Season.WINTER); // можно обратиться напрямую к любому элементу перечисления
        { // практическое использование
            // вывод всего перечисления на печать
            Season season = Season.SPRING;
            if (season == Season.SPRING) season = Season.SUMMER;
            System.out.println(season);
            System.out.println(Arrays.toString(Season.values())); // только обертку массивов нужно импортировать (см выше)
            // установка значения по строковому представлению
            String name = "AUTUMN";
            season = Season.valueOf(name); // этот метод пришел от предка при наследовании
            System.out.println(season);
        }
        {  // добавление адекватного строкового представления, хотя тоже самое можно сделать через геттер.
            Urgency urgency = Urgency.HIGH;
            System.out.println(urgency.perfomance()); // Срочно
        }

    }
}
