/**
 * Класс WeatherController
 *
 * @author : Хильченко А.Н
 * @project : HW_7_MVC
 * @date : 18.12.2021
 * @comments :
 */

package controller;

import model.WeatherResponse;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class WeatherController {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static String APPID = "1c87217667796841773e3feec12cbc74";

    /**
     * Получение погоды по названию города
     * @param city
     * @return
     */
    public static WeatherResponse getWeatherFromCity(String city) throws IOException {
        String urlAddres = "http://api.openweathermap.org/data/2.5/forecast?q="+city+"&appid="+APPID+"&units=metric";
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL(urlAddres);
            URLConnection urlConn = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            String line;
            while((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch(Exception e) {
            System.out.println("Такого города нет в openweathermap!");
            return new WeatherResponse();
        }
        WeatherResponse response = objectMapper.readValue(content.toString(), WeatherResponse.class);

        return response;
    }
}
