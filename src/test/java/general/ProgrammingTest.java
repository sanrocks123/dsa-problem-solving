/* (C) 2019 */
package general;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source ProgrammingTest.java created on Dec 19, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class ProgrammingTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testCharOccurenceCount() {
        final String str = "abcaaebcc";
        final String a[] = new String[str.length()];

        String unique = new String();
        for (int i = 0; i < str.length(); i++) {
            final String currentChar = Character.valueOf(str.charAt(i)).toString();
            if (!unique.contains(currentChar)) {
                unique = unique + currentChar;
            }
        }

        log.info("unique chars, i/p {}, o/p {}", str, unique);
        a[0] = unique;

        for (int i = 1; i < str.length(); i++) {
            a[i] = "";
        }

        for (int i = 0; i < str.length(); i++) {
            final String currentChar = Character.valueOf(str.charAt(i)).toString();
            log.info("currentChar {}", currentChar);
            for (int j = 0; j < a.length; j++) {
                if (a[j].contains(currentChar)) {
                    final String temp = a[j].replace(currentChar, "");
                    log.info(
                            "match found in array, removed current char {}, o/p {}",
                            currentChar,
                            temp);
                    a[j] = temp;
                    a[j + 1] = a[j + 1] + currentChar;

                    log.info("current array {}", Arrays.asList(a));
                    break;
                }
            }
        }

        log.info("result {}", Arrays.asList(a));
    }

    @Disabled
    @Test
    public void testDivisor() {
        // Scanner
        final Scanner s = new Scanner(System.in);
        final int totalNums = Integer.valueOf(s.nextLine());

        for (int k = 0; k < totalNums; k++) {
            final int n = Integer.valueOf(s.nextLine());
            System.out.println("Current Num : " + n);
            final List<Integer> divisors = new ArrayList<>();

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    divisors.add(i);
                }
            }

            System.out.println("divisor list : " + divisors);
            int sum = 0;
            for (final int i : divisors) {
                sum = sum + i;
            }

            System.out.println("sum : " + sum);
            if (sum == n) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    /** */
    @Disabled
    @Test
    public void testSweetness() {
        // Scanner
        final Scanner s = new Scanner(System.in);
        final int totalNums = Integer.valueOf(s.nextLine());
        final double log2 = Math.log(2);
        for (int i = 0; i < totalNums; i++) {

            final String[] line = s.nextLine().split(" ");
            final int C = Integer.valueOf(line[0]);
            final int S = Integer.valueOf(line[1]);

            double currentSweetnes = 0.0d;

            for (int j = 1; j < S; j++) {

                currentSweetnes = C * j * Math.sqrt(Double.valueOf(j)) * Math.log(j) / log2;
                System.out.println(
                        MessageFormat.format(
                                "j={0}, currentSweetness={1}", new Object[] {j, currentSweetnes}));

                if (currentSweetnes > S) {
                    System.out.println(j - 1);
                    break;
                }
            }
        }
        s.close();
    }
}
