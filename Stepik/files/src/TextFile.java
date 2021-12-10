/**
 * работа с текстовым файлом (чтение/запись и перебор строк)
 *
 * @author : Хильченко А.Н
 * @project : files
 * @date : 06.12.2021
 * @comments :
 *      Этот код читает содержимое файла, выводит егов консоль, полученное содержимое модифицирует и записывает
 *      в новый файл. ИМена файлов указаны в константах *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class TextFile {
    final static String INPUT_FILE = "/home/alex/DeskTop/in";
    final static String OUT_FILE = "/home/alex/DeskTop/out";

    static String textBuffer = "";

    static void readFile() {
        /*
        В данном случае считываем последовательно символы из файла в массив из 256 символов, пока не дойдем до конца
        файла в этом случае метод read возвратит число -1. Поскольку считанная порция файла может быть меньше 256
        символов (например, в файле всего 73 символа), и если количество считанных данных меньше размера буфера (256),
        то выполняем копирование массива с помощью метода Arrays.copy. То есть фактически обрезаем массив buf, оставляя
        в нем только те символы, которые считаны из файла.
        */

        try (FileReader reader = new FileReader(INPUT_FILE)) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                    textBuffer += Arrays.toString(buf);
                }
                System.out.print(buf);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void writeFile(String string) {
        try(FileWriter writer = new FileWriter(OUT_FILE, true)){
            // здесь true - это дописывать, если файла нет - он создается
        // запись всей строки
            writer.write(string);
        // запись по символам
            /*
            writer.append('\n');
            writer.append('E');
            */
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void readFileByLines(){
        // чтение файла построчно
        textBuffer = "";
            // здесь может быть другой объект для хранения текста
        try {
            FileReader f_reader = new FileReader(INPUT_FILE);
            BufferedReader reader = new BufferedReader(f_reader);
            String line = reader.readLine();
            while (line!= null) {
                System.out.println(line);
                line = reader.readLine();
                textBuffer+=line+'\n';
                    // Считанная строка не содержит возврата строки
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

        public static void main(String[]args) {
        // Чтение посимвольно
        readFile();
        System.out.println("Полученный при чтении посимвольно массив буквов: \n" + textBuffer);
        // трындец короче

        // Чтение построчно
        readFileByLines();
        System.out.println("Полученнная при чтении построчно строка: \n" + textBuffer);


        // Запись
        writeFile("Ахренеть можно\n");
        writeFile("Херня получается\n");
        writeFile("Как будто нет возможности работать с тектовыми фалами нормально\n");
    }

}
