/* (C) 2023 */
package general;

import org.junit.jupiter.api.Test;

/**
 * Java Source ShapeTest.java created on Jun 12, 2020
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class ShapeTest {

    @Test
    public void testNumberPyramid() {
        final int n = 10;
        for (int i = 1; i < n; i++) {
            System.out.println("");
            final int[] temp = new int[n];

            for (int j = 1; j <= i; j++) {

                for (int k = 1; k < n; k++) {
                    // fill up array starting from center and added padding from
                    // left right
                    // temp[k] = j;
                }
                temp[j] = j;
            }

            for (final int element : temp) {
                System.out.print(element);
            }
        }
    }

    @Test
    public void testStringReverse() {
        stringReverse(-1, "Sanjeev");
    }

    /**
     * @param string
     */
    private void stringReverse(int currentPos, String str) {

        if (currentPos == str.length() - 1) {
            return;
        }

        currentPos++;
        stringReverse(currentPos, str);
        System.out.print(str.charAt(currentPos));
    }
}
