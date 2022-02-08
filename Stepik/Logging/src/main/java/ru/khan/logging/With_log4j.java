/**
 * Класс With_log4j
 *
 * @author : Хильченко А.Н
 * @project : Logging
 * @date : 08.02.2022
 * @comments : НАстройки находятся в файле /resources/log4j.properties
 */

package ru.khan.logging;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;

public class With_log4j {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger("MyLog4j_Logger");
        logger.setLevel(Level.ALL);
        logger.trace("sldkfs;ldkfsl;dfk"); // остальное как везде



    }

}
