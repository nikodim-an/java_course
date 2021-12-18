/**
 * Класс WeatherResponse
 *      класс ответа сервера
 * @author : Хильченко А.Н
 * @project : HW_7_MVC
 * @date : 18.12.2021
 * @comments :
 */

package data;
import java.util.*;

public class WeatherResponse {      // Полный ответ по форме 5 дневного
    String cod;
    Integer message;
    Integer cnt;
    List<SituateWeather> list;
    City city;

    // конструкторы и геттеры
    public WeatherResponse() {
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

