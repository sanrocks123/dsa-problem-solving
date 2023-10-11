/* (C) 2023 */
package general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Java Source GSTest.java created on Jul 12, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class ExampleTest {

    @Test
    public void testHashCode() {
        final String s1 = new String("Sanjeev");
        final String s2 = "Sanjeev";
        final String s3 = s1;
        final String s4 = "Sanjeev";
        Assertions.assertEquals(s1.hashCode(), s2.hashCode());

        System.out.println(s1 == s2); // false
        System.out.println(s1 == s3); // true
        System.out.println(s2 == s4); // true
    }

    @Test
    public void testIntegerReference() {
        final Integer n1 = 100;
        final Integer n2 = 100;

        final String s1 = "s1";
        final String s2 = "s1";

        System.out.println(s1 == s2); // true
        System.out.println(n1 == n2); // true
    }

    @Test
    public void testSample() {
        System.out.println(Math.max(1, 2));
    }
}
