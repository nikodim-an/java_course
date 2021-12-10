/**
 * Класс SymbolStreams
 *
 * @author : Хильченко А.Н
 * @project : files
 * @date : 10.12.2021
 * @comments :
 *
 * Работа с текстовыми потоками
 * аналогичный пример в классе TextFile, но там все много по-другому.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class SymbolStreams {
    final static String FILE = "/home/alex/DeskTop/file.txt";
    final static String myText = "Мама мыла раму \n Мама Мыла раму \n Мама мыла раму \nПапа прятал гвоздь…";
        // типа текст который по идее большой

    public static void main(String[] args) {
        // запись в текстовый файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            writer.write(myText);
        } catch (Exception e) {
            System.out.println(e);
        }

        // чтение из файла
        String res = "";    //  результат
        String line= "";    //  считанная строка
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            // чтение возможно только построчно
            while ((line=reader.readLine())!=null) {
                res+=line+'\n';
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(res);
    }


}
