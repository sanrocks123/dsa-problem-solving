/* (C) 2023 */
package problemsolving;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source HayStackNeedleTest.java created on Feb 24, 2020
 *
 * @author : Sanjeev Saxena
 * @version : 1.0
 * @email : sanrocks123@gmail.com
 */
public class HayStackNeedleTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * Find occurrence position of given needle string m of size k in haystack n
     *
     * <p>Input 2, na, banananobanono
     *
     * <p>Output 2,4
     */
    @Test
    public void testCase1() {
        final String result = findPosition(2, "na", "banananobanono");
        Assertions.assertEquals("2,4", result);
    }

    /**
     * @param keyLength
     * @param key
     * @param messageHash
     * @return
     */
    private String findPosition(int keyLength, String key, String messageHash) {
        log.info("count: {}, lookup: {}, stack: {}", keyLength, key, messageHash);

        final StringBuilder sb = new StringBuilder();
        final char[] tokens = messageHash.toCharArray();
        int i = 0;

        while (i < tokens.length - 1) {
            final String token = Character.valueOf(tokens[i]).toString();
            log.info("current [{}] token: {}", i, token);

            if (key.startsWith(token)) {
                final String keyMatch = messageHash.substring(i, i + keyLength);

                if (keyMatch.equalsIgnoreCase(key)) {
                    log.info("keyMatch: {}", keyMatch);
                    sb.append(i).append(",");
                    i = i + keyLength;
                    continue;
                }
            }
            i++;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
