/**
 * Класс WeatherViewer
 *
 * @author : Хильченко А.Н
 * @project : HW_7_MVC
 * @date : 18.12.2021
 * @comments :
 */

package view;

import java.io.IOException;
import java.util.*;
import model.*;
import controller.WeatherController;

public class WeatherViewer {

    public static void consoleView(WeatherResponse data){
        System.out.println(data);
    }

    public static void processCity() throws IOException {
        // бесконечный цикл опроса ввода из консоли.
        while (true) {
            Scanner sc = new Scanner(System.in);
            String city = sc.nextLine();
            if (city.equals("exit")) {
                break;
            } else {
                consoleView(WeatherController.getWeatherFromCity(city));
            }
        }
    }

}
