package data; /**
 * Класс Weather
 *
 * @author : Хильченко А.Н
 * @project : HW_7_MVC
 * @date : 18.12.2021
 * @comments :
 */

import java.util.*;

public class Weather{
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