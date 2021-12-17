/**
 * Класс Formaters
 *
 * @author : Хильченко А.Н
 * @project : StringType
 * @date : 18.12.2021
 * @comments :
 */

import java.text.MessageFormat;
import java.util.*;

public class Formaters {

    public static void main(String[] args) {
        String resStr;
        String nonFormatMessage = "{0} мыла {1}";
        // самый простой вариант форматирования - простое сложение строк
        System.out.println("-- Простое сложение строк ---------------------");
        String str1 = "Мама";
        String str2 = "раму";
        resStr = str1+" мыла "+str2;
        System.out.println(resStr);

        //простое форматирование
        System.out.println("-- Простое форматирование ---------------------");
        resStr = String.format("%s мыла %s", str1, str2);
                // %s вставить строку, %d вставить целое, %f - вставить Double
        System.out.println(resStr);

        // форматирование сообщений
        System.out.println("-- Форматирование строк как сообщений ---------");
        resStr = MessageFormat.format(nonFormatMessage, str1, str2);
        System.out.println(resStr);
        resStr = MessageFormat.format(nonFormatMessage, str2, str1);
        System.out.println(resStr);

        // а f-string в java нет, как и аналогов.

    }
}
