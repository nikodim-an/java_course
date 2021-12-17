/**
 * Класс main_stend
 *
 * @author : Хильченко А.Н
 * @project : homework 6
 * @date : 12.12.2021
 * @comments : Это стенд к домашней работе!!!! Он получает погоду с сервера погоды openweathermap по api ключу.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

class Main{             // основные погодные характеристики
    Double temp;
    Double feels_like;
    Double temp_min;
    Double temp_max;
    Integer pressure;
    Integer sea_level;
    Integer grnd_level;
    Integer humidity;
    Double temp_kf;

    public Main() {
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Double feels_like) {
        this.feels_like = feels_like;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getSea_level() {
        return sea_level;
    }

    public void setSea_level(Integer sea_level) {
        this.sea_level = sea_level;
    }

    public Integer getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(Integer grnd_level) {
        this.grnd_level = grnd_level;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(Double temp_kf) {
        this.temp_kf = temp_kf;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }
}

class Weather{
    Integer id;
    String main;
    String description;
    String icon;

    public Weather() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return description;     // переводить на русский язык не стал - задача состояит не в этом.
    }
}

class Clouds{
    Integer all;

    public Clouds() {
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

}

class Wind {
    Double speed;
    Double deg;
    Double gust;

    public Wind() {
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDeg() {
        return deg;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }

    public Double getGust() {
        return gust;
    }

    public void setGust(Double gust) {
        this.gust = gust;
    }
}

class Sys {
    String pod;

    public Sys() {
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)  // игнорируем недекларированные
class SituateWeather{   // погодная ситуация
    /*
     * Здесь я игнорирую недекларированные поля, потому что невозможно в java использовать переменные вида 3h
     * во-первых, и это поле есть не в каждой записи о погодной ситуации в пределах детализации. В данном случае
     * игнорировать его выгодней, чем завести.
     * это поле показывает вероятность осадков в географической точке в ближайшие 3 часа. При выводе обойдусь без него.
     */
    Long dt;            // это дата
    Main main;
    List<Weather> weather;
    Clouds clouds;
    Wind wind;
    Integer visibility;
    Integer pop;
    Sys sys;
    String dt_txt;

    public SituateWeather() {
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Integer getPop() {
        return pop;
    }

    public void setPop(Integer pop) {
        this.pop = pop;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "\t\t" + dt_txt +
                ",\tсредняя температура "+main.getTemp()+",\t ветер "+wind.getSpeed()+"м/с"+ ",\t состояние - "+weather+
                "\n";
        // а больше я не знаю что вывести - но вывести могу все что угодно из пришедшего.
    }
}

class Coord {           // координаты места
    Double lat;
    Double lon;

    public Coord() {
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}

class City{             // текущий город
    Integer id;
    String name;
    Coord coord;
    String country;
    Integer population;
    Integer timezone;
    Long sunrise;
    Long sunset;

    public City() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "город " + name + "(" + country+")";
    }
}

class Answer{      // Полный ответ по форме 5 дневного
    String cod;
    Integer message;
    Integer cnt;
    List<SituateWeather> list;
    City city;

    // конструкторы и геттеры
    public Answer() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public List<SituateWeather> getList() {
        return list;
    }

    public void setList(List<SituateWeather> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    // преобразование в строку
    @Override
    public String toString() {
        return "Ответ сервера погоды:\n" +
                "\tМесто: " + city + ".\n\tПрогноз погоды на 5 дней (детализация 3 часа):\n"+ list;
    }
}

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
         */
        String addres = "http://api.openweathermap.org/data/2.5/forecast?q="+CITY+"&appid="+API_KEY+"&units=metric";
        String jsonAnswer = getUrlContent(addres); // это погода на пять дней в формате json
        // теперь нужно распарсить этот ответ, дял этого воспользуюсь внешней библиотекой (лежит в /lib)
        // Jackson Databind
        ObjectMapper objectMapper = new ObjectMapper();
        Answer answer = objectMapper.readValue(jsonAnswer, Answer.class);
        System.out.println(answer);

    }

}

/* Вывод в консоль
Ответ сервера погоды:
	Место: город Saint Petersburg(RU).
	Прогноз погоды на 5 дней (детализация 3 часа):
[		2021-12-16 09:00:00,	средняя температура 2.38,	 ветер 1.39м/с,	 состояние - [overcast clouds]
, 		2021-12-16 12:00:00,	средняя температура 2.18,	 ветер 2.94м/с,	 состояние - [overcast clouds]
, 		2021-12-16 15:00:00,	средняя температура 0.97,	 ветер 4.74м/с,	 состояние - [overcast clouds]
, 		2021-12-16 18:00:00,	средняя температура 1.13,	 ветер 4.4м/с,	 состояние - [overcast clouds]
, 		2021-12-16 21:00:00,	средняя температура 1.29,	 ветер 4.45м/с,	 состояние - [overcast clouds]
, 		2021-12-17 00:00:00,	средняя температура -3.34,	 ветер 3.14м/с,	 состояние - [broken clouds]
, 		2021-12-17 03:00:00,	средняя температура -3.44,	 ветер 3.68м/с,	 состояние - [few clouds]
, 		2021-12-17 06:00:00,	средняя температура -3.98,	 ветер 3.6м/с,	 состояние - [few clouds]
, 		2021-12-17 09:00:00,	средняя температура -3.43,	 ветер 3.5м/с,	 состояние - [scattered clouds]
, 		2021-12-17 12:00:00,	средняя температура -3.36,	 ветер 3.54м/с,	 состояние - [scattered clouds]
, 		2021-12-17 15:00:00,	средняя температура -2.72,	 ветер 4.1м/с,	 состояние - [broken clouds]
, 		2021-12-17 18:00:00,	средняя температура -3.77,	 ветер 3.17м/с,	 состояние - [broken clouds]
, 		2021-12-17 21:00:00,	средняя температура -8.59,	 ветер 1.91м/с,	 состояние - [broken clouds]
, 		2021-12-18 00:00:00,	средняя температура -10.5,	 ветер 1.74м/с,	 состояние - [broken clouds]
, 		2021-12-18 03:00:00,	средняя температура -9.51,	 ветер 1.81м/с,	 состояние - [overcast clouds]
, 		2021-12-18 06:00:00,	средняя температура -4.04,	 ветер 3.02м/с,	 состояние - [overcast clouds]
, 		2021-12-18 09:00:00,	средняя температура -0.74,	 ветер 4.62м/с,	 состояние - [light snow]
, 		2021-12-18 12:00:00,	средняя температура 1.0,	 ветер 5.37м/с,	 состояние - [light rain]
, 		2021-12-18 15:00:00,	средняя температура 1.78,	 ветер 5.18м/с,	 состояние - [overcast clouds]
, 		2021-12-18 18:00:00,	средняя температура 1.51,	 ветер 5.02м/с,	 состояние - [overcast clouds]
, 		2021-12-18 21:00:00,	средняя температура 0.43,	 ветер 4.97м/с,	 состояние - [overcast clouds]
, 		2021-12-19 00:00:00,	средняя температура -1.56,	 ветер 2.69м/с,	 состояние - [overcast clouds]
, 		2021-12-19 03:00:00,	средняя температура -1.7,	 ветер 3.08м/с,	 состояние - [overcast clouds]
, 		2021-12-19 06:00:00,	средняя температура -2.39,	 ветер 3.12м/с,	 состояние - [overcast clouds]
, 		2021-12-19 09:00:00,	средняя температура -2.83,	 ветер 3.6м/с,	 состояние - [overcast clouds]
, 		2021-12-19 12:00:00,	средняя температура -3.64,	 ветер 4.55м/с,	 состояние - [light snow]
, 		2021-12-19 15:00:00,	средняя температура -6.71,	 ветер 4.53м/с,	 состояние - [light snow]
, 		2021-12-19 18:00:00,	средняя температура -7.39,	 ветер 5.02м/с,	 состояние - [light snow]
, 		2021-12-19 21:00:00,	средняя температура -8.5,	 ветер 5.57м/с,	 состояние - [light snow]
, 		2021-12-20 00:00:00,	средняя температура -9.1,	 ветер 5.96м/с,	 состояние - [light snow]
, 		2021-12-20 03:00:00,	средняя температура -10.11,	 ветер 6.55м/с,	 состояние - [overcast clouds]
, 		2021-12-20 06:00:00,	средняя температура -10.74,	 ветер 6.1м/с,	 состояние - [light snow]
, 		2021-12-20 09:00:00,	средняя температура -11.05,	 ветер 6.04м/с,	 состояние - [light snow]
, 		2021-12-20 12:00:00,	средняя температура -10.7,	 ветер 5.46м/с,	 состояние - [overcast clouds]
, 		2021-12-20 15:00:00,	средняя температура -11.18,	 ветер 5.06м/с,	 состояние - [overcast clouds]
, 		2021-12-20 18:00:00,	средняя температура -10.99,	 ветер 4.94м/с,	 состояние - [overcast clouds]
, 		2021-12-20 21:00:00,	средняя температура -11.48,	 ветер 4.59м/с,	 состояние - [overcast clouds]
, 		2021-12-21 00:00:00,	средняя температура -12.52,	 ветер 4.04м/с,	 состояние - [overcast clouds]
, 		2021-12-21 03:00:00,	средняя температура -12.94,	 ветер 3.7м/с,	 состояние - [overcast clouds]
, 		2021-12-21 06:00:00,	средняя температура -13.86,	 ветер 3.09м/с,	 состояние - [broken clouds]
]

 */
