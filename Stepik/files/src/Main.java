/**
 * Проба пера в сохненинии настроек. ну и работа с файлами
 *
 * @author : Хильченко А.Н
 * @version : номер, дата
 */

/*
Для примера возьму учебную задачу:
пусть имеется некий файл конфигурации в директории .config/my_stend/ (имя фала stend.settings)
 - если этого файла и директории нет в природе (а это значит что это первый запуск программы), то нужно его создать
 и применить настройки по умолчнию (какой-то текст по умолчнию)
 - если файл имеется то из него нужно прочитать текст и вывести его в терминал
 - полученный текст модифициорвоать (например повторить его дважды)
 - сохранить тест в файл (переписав его).
 */


import java.io.File;

public class Main {
    public static final String PATH = "/home/alex/.config/my_stend/stend.settings";



    public static void main(String[] args) {
        File file = new File(PATH);
        if (!file.exists()) {
            System.out.println("Файла не существует");
            //file.createNewFile();
        }

    }
}
