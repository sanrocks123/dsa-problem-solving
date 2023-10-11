/* (C) 2017 */
package designpatterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Java Source CreationalDesignPatternTest.java created on Nov 27, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
@Slf4j
public class CreationalDesignPatternTest {

    @Test
    public void testSingleton() throws InterruptedException {

        final ExecutorService execService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            execService.execute(
                    () -> {
                        Singleton.getInstance();
                    });
        }
        execService.shutdown();
        execService.awaitTermination(5, TimeUnit.MINUTES);
    }

    @Test
    // @Ignore
    public void testSingletonEnum() throws InterruptedException {

        final ExecutorService execService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            execService.execute(
                    () -> {
                        log.info("started");
                        SingletonEnum.INSTANCE.getAtomicInteger();
                    });
        }
        execService.shutdown();
        execService.awaitTermination(5, TimeUnit.MINUTES);
    }
}
