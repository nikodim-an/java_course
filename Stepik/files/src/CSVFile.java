/**
 * Класс CSVFile
 *
 * @author : Хильченко А.Н
 * @project : files
 * @date : 09.12.2021
 * @comments :
 */

import java.io.File;
import java.io.FileReader;

class AppData {
    private String[] headers;
    private int[][] data; // вот тут просится список из массивов

    public AppData(int size, String headerLine) {
        this.headers = headerLine.split(",");
        int y = this.headers.length;
        data = new int[size][y];
    }

    public AppData(int size, String headerLine, int[][] data) {
        this.headers = headerLine.split(",");
        this.data = data;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

}

public class CSVFile {
    // константы
    final static String INPUT_FILE = "/home/alex/DeskTop/in.csv";
    final static String OUT_FILE = "/home/alex/DeskTop/out.csv";

    public static void saveToCSVFile(){
        // сохранение в csv файл
    }

    public static void loadFromCSVFile(){
        // чтение из файла
    }


    public static void main(String[] args) {
        File f = new File(INPUT_FILE);
        System.out.println(f.exists());
        try{
            f.createNewFile();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(f.exists());

    }
}
