package iq_soft;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static iq_soft.Logging.logger;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */


    @Test
    public void test1() {
        // positive test
        logger.info(App.getValue(2));
        logger.info(4==App.getValue(2));
        assertTrue (4==App.getValue(2)); // true
        logger.info("Тест 1 - пройден");
    }

    @Test
    public void test2() {
        // negative test
        logger.info(4==App.getValue(3));
        assertFalse (4==App.getValue(3)); // false
        logger.info("Тест 2 - пройден");
    }
}
