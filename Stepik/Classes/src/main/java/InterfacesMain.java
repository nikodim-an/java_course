public class InterfacesMain {

    // ничего умнее пульа от телевизора не выдумал, к сожалению…
    interface TVControll { // если бы это было в другом файле - то нужно было бы указывать модификатор доступа
        public void volumeUp(); // громче
        public void volumeDowd(); // тише
        public void programmUp(); // следующая программа
        public void programDown();// предыдущая
    }

    static class TV implements TVControll {
        public int programm;
        public int volume;
        public String nameTV;

        public void volumeUp(){
            this.volume += 5;
            if (this.volume > 100) { this.volume = 100; }
            System.out.println("Текущаяя громкость - "+this.volume);
        };
        public void volumeDowd(){
            this.volume -= 5;
            if (this.volume <0) { this.volume = 0; }
            System.out.println("Текущаяя громкость - "+this.volume);
        };
        public void programmUp(){
            this.programm ++;
            if (this.programm > 99) { this.programm = 0; }
            System.out.println("Текущая программа - "+this.programm);
        };

        public void programDown(){
            this.programm --;
            if (this.programm < 0 ) { this.programm = 99; }
            System.out.println("Текущая программа - "+this.programm);
        };

        public TV() {
            this.programm = 1; // телек будет с первой программой
            this.volume = 30; // и на середине громкости
            this.nameTV = "NoName… (китай короче)";
        }

        public TV(String name) {
            this.programm = 1; // телек будет с первой программой
            this.volume = 30; // и на середине громкости
            this.nameTV = name;
        }

    }

    public static void main(String[] args) {
        TV tv = new TV();
        System.err.println("Работаем с телевизором - "+tv.nameTV);
        tv.programmUp();
        tv.programmUp();
        tv.programmUp();
        tv.programmUp();
        tv.programmUp();
        System.err.println("Поймали чето интересное, но тихо");
        tv.volumeUp();
        tv.volumeUp();
        tv.volumeUp();
        tv.volumeUp();
        tv.volumeUp();
        System.err.println("Будем смотреть...");
        tv.volume = 3; // смоделируем установку с пульта 3 звука...
        tv.volumeDowd();
        tv.volumeDowd();
        tv.volumeDowd();
        tv.volumeDowd();
        tv.volumeDowd();
        TV tv1 = new TV("FunAiva");
        System.err.println("Работаем с телевизором - "+tv1.nameTV);
        tv1.programm = 85; tv1.volume = 98;
        System.err.println("    Его канал - "+tv1.programm);
        System.err.println("    Его громкость - "+tv1.volume);
        tv1.volumeUp();
    }
}

/*
Резюмирую - интерфейс — это набор методов которые нужно «незабыть» объявить в классе... если
метод по каким то причинам не объявлен в классе - программа не скомпилируется…
 */
