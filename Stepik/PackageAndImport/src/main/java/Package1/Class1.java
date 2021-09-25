package Package1;

import Package2.Class3;
/*
Здесь можно было еще импортировать все классы пакета, написав import Package2.*
только имена пакетов должны начинаться с маленькой (!) буквы.
 */
public class Class1 {

    public static void main(String[] args) {
        ClassForImport.sendMessage("в одном модуле можно не импортировать ничего, а напрямую обратиться к классу");
        /*
        кроме того в модуле может быть только один публичный класс
        поэтому все остальные импорторировать не получится
        */
        Class2.sendMessage("классы одного пакета тоже можно не импортировать, если они лежат в одной папке");
        Class3.sendMessage("импортированный класс через import");
        ru.kh.package1.Class4.sendMessage("обращение к методу класса без явного импорта");
    }

}

class ClassForImport { //на самом деле его нельзя импортировать
    public static void sendMessage(String message) {
        System.out.println(message);
    }
}