/**
 * Класс FileInputOutputStream
 *
 * @author : Хильченко А.Н
 * @project : files
 * @date : 10.12.2021
 * @comments :
 *
 *  Это код записывающий и читающий слово из констант
 *
 */



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileInputOutputStream {
    final static String FILE = "/home/alex/DeskTop/file";
    final static String WORD = "JAVA";

    public static void main(String[] args) {
        // пишем в файл слово java
        byte[] outData = WORD.getBytes();           // преобразовали слово в массив байт
        System.out.println(outData[0]);             // 74 - ???
        try (FileOutputStream out = new FileOutputStream(FILE)) {
            out.write(outData);
        } catch (Exception e) {
            System.out.println(e);
        }

        String res="";
        // читаем из файла слово посимвольно, но это очень медленно!!!
        int s;
        try (FileInputStream in = new FileInputStream(FILE)) {
            while ((s = in.read())!=-1) {
                res+=(char) s;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(res);res = "";

        // читаем из файла слово используя буфер (байтовый массив)
        System.out.println("---------------------------------------------------------------------------");
        byte[] buff = new byte[20];     // размер не важен, но определяет разовую порцию при чтении
        try (FileInputStream in = new FileInputStream(FILE)) {
            while ((s = in.read(buff))!=-1) {   // здесь возвращается количесвто прочитанных байт
                // поскольку тут массив, то нужно его перебрать
                for (int i = 0; i < s; i++) {
                    res+=(char) buff[i];
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(res);res = "";

        //
    }

}
