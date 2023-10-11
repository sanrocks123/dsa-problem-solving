/* (C) 2023 */
package general;

import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source CompletableFutureTest.java created on Feb 19, 2020
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class CompletableFutureTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testCompletableFuture() {

        CompletableFuture.runAsync(() -> log.info("hello world"));
    }
}
