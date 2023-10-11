/* (C) 2023 */
package general;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

/**
 * Java Source StaticLockTest.java created on Jul 12, 2021
 *
 * @author : Sanjeev Saxena
 * @version : 1.0
 * @email : sanrocks123@gmail.com
 */
public class StaticLockTest {

    public synchronized void a() throws InterruptedException {
        System.out.println("display a, lock acquired... sleeping for 2 seconds");
        TimeUnit.SECONDS.sleep(2);
    }

    public synchronized void b() throws InterruptedException {
        System.out.println("display b, sleeping for 3 seconds");
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    public void testStaticMethod() throws InterruptedException {

        new Thread(
                        () -> {
                            try {
                                new StaticLockTest().a();
                            } catch (final InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        },
                        "a")
                .start();

        new Thread(
                        () -> {
                            try {
                                new StaticLockTest().b();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        "b")
                .start();

        TimeUnit.SECONDS.sleep(8);
    }
}
