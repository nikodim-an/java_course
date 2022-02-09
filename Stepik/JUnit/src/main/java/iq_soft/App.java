package iq_soft;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {
    public static Logger logger = LogManager.getLogger("MainLogger");

    public static void main( String[] args )
    {
        logger.info( "Hello World!" );
    }

    public static Integer getValue(Integer inValue) {
        return 2*inValue;
    }
}
