/**
 * Класс main_stend
 *
 * @author : Хильченко А.Н
 * @project : homework 6
 * @date : 12.12.2021
 * @comments : Это стенд к домашней работе!!!! Он получает погоду с сервера погоды openweathermap по api ключу.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class main_stend {
    final static String CITY = "Санкт-Петербург";
    final static String API_KEY = "1c87217667796841773e3feec12cbc74";

    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            String line;
            while((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch(Exception e) {
            System.out.println("Такого города нет в openweathermap!");
        }
        return content.toString();
    }


    public static void main(String[] args) throws Exception{
        /* Поиск города выполнять не нужно, сервис сам находит его по названию, причем название можно давать по-русски
         * или передать жестко ижентификатор города - дял СПб это 498817 в этом случае строка запроса будет немного
         * иной. Для запроса текущей погоды в городе нужно дать запрос на адрес (в переменных):
         *      "http://api.openweathermap.org/data/2.5/weather?q="+CITY+"&appid="+API_KEY+"&units=metric"
         * а для получения погоды на 5 дней с трехчасовой детализацией:
         *      "http://api.openweathermap.org/data/2.5/forecast?q="+CITY+"&appid="+API_KEY+"&units=metric"
         * и приходит ответ сразу в формате json.
         * Задачи разбирать ответ небыло, поэтому я его просто выведу.
         */
        String addres = "http://api.openweathermap.org/data/2.5/forecast?q="+CITY+"&appid="+API_KEY+"&units=metric";
        String answer = getUrlContent(addres);
        System.out.println(answer); // погода на 5 дней в формате JSON …
    }

}
