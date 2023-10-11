/* (C) 2023 */
package problemsolving;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source OracleTest.java created on Aug 7, 2020
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class OracleTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /** */
    @Test
    public void testGeometriProgression() {

        final int[] a = new int[] {1, 3, 9, 9, 27, 81};

        for (int i = 0; i < a.length; i++) {
            log.info("-----  i:[{}], value:{}", i, a[i]);

            for (int j = i + 1; j < a.length - 1; j++) {

                int div = 1;
                if (a[j] % a[i] == 0) {
                    div = a[j] / a[i];
                    // log.info("a[j]/a[i], {}/{} = {}", a[j], a[i], div);

                    for (int k = j + 1; k <= a.length - 1; k++) {
                        // log.info("a[j]*a[i]== a[k], {}*{} == {}", a[j], div,
                        // a[k]);
                        if (a[j] * div == a[k]) {
                            log.info("triplet found {}{}{}", i, j, k);
                        }
                    }
                }
            }
        }
    }
}
