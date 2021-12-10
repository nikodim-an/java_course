/**
 * Класс BufferedInputOutputStream
 *
 * @author : Хильченко А.Н
 * @project : files
 * @date : 10.12.2021
 * @comments :
 */

import java.io.*;
import java.util.*;

public class BufferedInputOutputStream {
    final static String FILE = "/home/alex/DeskTop/file1";
    final static String WORD = "JAVA1";

    public static void main(String[] args) {
        // запись файла
        byte[] outData = WORD.getBytes();           // преобразовали слово в массив байт
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(FILE))) {
            for (int i = 0; i < outData.length; i++) {
                out.write(outData[i]);
            }
            // или так, если есть в наличии готовый массив:
            //out.write(outData);
        } catch (Exception e) {
            System.out.println(e);
        }

        // чтение файла посимвольно?! как в методичке…
        String res = "";
        int x;
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(FILE))){
            while ((x = in.read())!=-1){
                // тока оно в примере идет посивольно (!) … ?!
                res+=(char) x;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(res); res = "";
        System.out.println("--------------------------------------------------------");

        // чтение файла буфером
        byte[] buff = new byte[20]; // размер снова не имеет значение
        // int x; - уже определен ранее
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(FILE))){
            while ((x = in.read(buff))!=-1){
                for (int i=0; i<buff.length; i++) {
                    res+=(char) buff[i];
                    // как в рекламе про досю - а собственно нахер????!
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(res); res = "";
        System.out.println("--------------------------------------------------------");


    }
}
