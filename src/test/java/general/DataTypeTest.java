/* (C) 2019 */
package general;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source DataTypeTest.java created on Dec 19, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class DataTypeTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testBigDecimal() {
        final float d1 = 0.0000007f;
        final float d2 = 0.0000001f;

        log.info("add : [{}, {}] -> {}", d1, d2, d2 + d1);
        log.info("sub : [{}, {}] -> {}", d1, d2, d2 - d1);
        log.info("eq  : [{}, {}] -> {}", d1, d2, d2 == d1);

        final BigDecimal b1 = new BigDecimal(0.01);
        final BigDecimal b2 = new BigDecimal(0.02);

        log.info("b2-b1 {}", b2.subtract(b1).round(MathContext.DECIMAL32));
    }

    @Test
    public void testDoubleOperations() {
        final Double object = new Double("2.4");

        final int a = object.intValue();
        log.info("a: {}", a);

        final byte b = object.byteValue();
        log.info("b: {}", b);

        final double c = object.doubleValue();
        log.info("c: {}", c);

        final float d = object.floatValue();
        log.info("d: {}", d);

        System.out.println(a + b + c + d);
    }

    @Test
    public void testInt() {
        final int t = 0123;
        System.out.println(t);
        log.info("t: {}", t);
    }

    @Test
    public void testIntegerLongComparison() {
        final Integer a = new Integer(2);
        final long b = 2000300040005000L;
        System.out.println(a == b);

        final int c = (int) b;
        System.out.println(c);
    }

    @Test
    public void testIntegerMatch() {

        // returns true
        Integer a = 127;
        Integer b = 127;

        Assertions.assertTrue(a == b);

        // returns false
        a = 1000;
        b = 1000;
        Assertions.assertFalse(a == b);

        // primitive comparison wins
        // final int i = 1000;
        // final int j = 1000;
        // Assert.assertEquals(true, i == j);
    }

    @Test
    public void testNumbers() {
        final BigDecimal a = new BigDecimal(1.2);
        final BigDecimal b = new BigDecimal(0.4);
        a.setScale(2, RoundingMode.UP);
        log.info("a+b = {}", a.add(b, MathContext.DECIMAL64));
    }
}
