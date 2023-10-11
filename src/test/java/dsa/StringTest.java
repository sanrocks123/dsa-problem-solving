/* (C) 2019 */
package dsa;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Java Source StringManipulationTest.java created on Dec 23, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class StringTest {

    @Test
    public void testHashMap() {
        final String s1 = "Sanjeev";
        final String s2 = new String("Sanjeev");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s1 == s2);

        final Map<String, String> map = new HashMap<>();
        map.put(s1, "s1");
        map.put(s2, "s2");

        System.out.println(map);
    }

    @Test
    public void testIntern() {

        // final String s1 = new String("Hello");
        final String s2 = new String("World");

        final String s3 = s2.intern();

        System.out.printf("s3: %s", s3);
        Assertions.assertNotSame(s3, s2);

        Assertions.assertSame(s3, s2.intern());
        Assertions.assertSame("World", s2.intern());
    }

    @Test
    public void testLongestPallindrome() {

        final String str = "forgeeksskeegfor";
        String result = "";

        final StringBuilder sub = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                sub.append(str.substring(i, j));
                // System.out.printf("sub i: %d, j: %d = %s\n", i, j, sub);

                if (sub.toString().equalsIgnoreCase(sub.reverse().toString())) {
                    // System.out.printf("pallindrome string found - %s : %s\n",
                    // sub.toString(), sub.reverse().toString());
                    result = sub.length() > result.length() ? sub.toString() : result;
                }
                sub.setLength(0);
            }
        }
        System.out.println("max len of longest substring - " + result);
    }

    @Test
    public void testRotationalCipher() {

        final String input = "All-convoYs-9-be:Alert1.";
        final int rotationFactor = 4;
        final String expected = "Epp-gsrzsCw-3-fi:Epivx5.";

        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            final char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                final int a = Character.isUpperCase(ch) ? 65 : 97;
                final char c = (char) ((ch + rotationFactor - a) % 26 + a);
                sb.append(Character.valueOf(c));
            } else if (Character.isDigit(ch)) {
                final char n = (char) ((ch + rotationFactor - 48) % 10 + 48);
                sb.append(Character.valueOf(n));
            } else {
                sb.append(ch);
            }
        }

        System.out.printf(
                "input: %s\nexpected: %s \noutput: %s \n", input, expected, sb.toString());
    }

    @Test
    public void testStringObjectNull() {
        new StringTest().hello(null);
        new StringTest().hello((Object) null);
    }

    @Test
    public void testSystemOverloading() {
        final String str = null;
        System.out.println(null + str);
        System.out.println(str + null);
    }

    private void hello(Object object) {
        System.out.printf("object: %s", object);
    }

    private void hello(String str) {
        System.out.printf("str: %s", str);
    }
}
