/**
 * Класс Mian
 *
 * @author : Хильченко А.Н
 * @project : JSON_maven
 * @date : 16.12.2021
 * @comments :
 */

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
// import com.fasterxml.jackson.databind.ObjectMapper;


class Car{
    String brand;
    String color;

    // это нужно чтобы его можно было создавать руками
    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    // это нужно чтобы объект мог создаваться из библиотеки Jackson
    public Car() {
        // конструктор по умолчанию
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Это не нужно ни для чего , кроме отображения в консоли
    @Override
    public String toString() {
        return "Car {" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

public class Mian {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();

        Car car1 = new Car("Лада седан", "Баклажан");
        Car car2 = new Car("Нива", "Хитрый металик");

        // преобразование в json
        String carFromJSON = objectMapper.writeValueAsString(car1);
        System.out.println(carFromJSON);

        // обратное преобразование
        Car newCar = objectMapper.readValue(carFromJSON, Car.class);
        System.out.println(newCar);


        // Объект посложнее
        HashMap<Integer, Car> map = new HashMap();

        map.put(1, car1);
        map.put(2, car2);
        map.put(3, new Car("Просто гелентваген, ниче особенного", "Говняный"));
        // выгрузка
        String mapFromJSON = objectMapper.writeValueAsString(map);
        System.out.println(mapFromJSON);
        //загрузка
        //HashMap<Integer, Car> newMap = objectMapper.readValue(mapFromJSON, map.getClass());
            // но это очень костыльно
        HashMap<Integer, Car> newMap = new HashMap();
        newMap = objectMapper.readValue(mapFromJSON, newMap.getClass());
            // а это тоже костыльно, но не так сильно

        System.out.println(newMap);




    }

}
