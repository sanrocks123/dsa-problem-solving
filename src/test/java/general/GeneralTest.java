/* (C) 2017 */
package general;

import domain.*;
import java.util.concurrent.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source GeneralTest.java created on Apr 17, 2019
 *
 * @author : Sanjeev Saxena
 * @version : 1.0
 * @email : sanrocks123@gmail.com
 */
public class GeneralTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void tesGarbageCollection() {
        OddEvenCounter oo = new OddEvenCounter(1, 5);
        oo = null;
        System.gc();
        log.info("endd {}", oo);
    }

    @Test
    public void testASCIICode() {

        try {
            System.out.println(Integer.valueOf("A".charAt(0)));
        } finally {
            System.out.println("finally");
        }
    }

    @Test
    public void testClone1() throws CloneNotSupportedException {
        final Employee e1 = new Employee(123, "sanjeev");
        log.info("e1: {}", e1);
        final Employee e2 = e1.clone();
        e2.setName("Saxena");
        log.info("e2: {}", e2);
    }

    @Test
    public void testErrors() {
        try {
            throw new Error("");
        } catch (final Error err) {
            log.info("Error", err);
        }
        log.info("Good to go after Error");
    }

    @Test
    public void testFactorialWithRecursive() {

        final int n = 3;
        System.out.printf("fact: %d ", factorial(n));
    }

    @Test
    public void testFindSumOfAll() {

        int hammer, saw, house = 0;

        int hammer_saw = 10;
        int house_saw = 20;
        int house_hammer = 24;

        // lets assume
        hammer = hammer_saw / 2;
        saw = hammer_saw - hammer;
        house = house_saw - saw;

        // while(hammer + )

    }

    @Test
    public void testImmutable() {

        ImmutableClass a = new ImmutableClass(1);
        final ExtendedImmutableClass b = new ExtendedImmutableClass(2);
        log.info("a : {}, b: {}", a.getId(), b.getId());

        b.setId(3);
        a = b;
        log.info("a : {}, b: {}", a.getId(), b.getId());
    }

    @Test
    public void testNullReferenceOverriding() {
        final ExtendedImmutableClass ext = new ExtendedImmutableClass(123);
        final Object aa = null;
        ext.printVal(aa);
    }

    @Test
    public void testObjectReferences() {

        String a = new String("A");
        String b = new String("B");

        a = new String("AA");
        b = null;
        a = b;

        log.info("a: {}, b: {}", a, b);
    }

    @Test
    public void testPriorityQueue() {
        final PriorityBlockingQueue<String> qq = new PriorityBlockingQueue<>();

        qq.put("c");
        qq.put("a");
        qq.put("d");
        qq.put("b");

        log.info("qq {}", qq);
    }

    @Test
    public void testTryCatchReturn() {
        Assertions.assertTrue(hello() == 1);
    }

    @Test
    public void testVolatile() {

        final Counter cc = new Counter();
        final Employee e1 = new Employee(1, "a");
        cc.setEmp(e1);

        log.info("cc init {}", cc);

        final Runnable r1 =
                () -> {
                    cc.m1();
                    cc.getEmp().setName("b");
                    log.info("r1 cc {}", cc);
                };

        final Runnable r2 =
                () -> {
                    // cc.m2();
                    // cc.getEmp().setName("c");
                    log.info("r2 cc {}", cc);
                };

        final ExecutorService eSvc = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            eSvc.execute(r1);
            eSvc.execute(r2);
        }

        eSvc.shutdown();
        while (!eSvc.isTerminated()) {}
    }

    /**
     * @param n
     * @return
     */
    private int factorial(int n) {

        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * @return
     */
    @SuppressWarnings("finally")
    private int hello() {
        try {
            return 0;
        } catch (final Exception ex) {
            System.out.println("this is catch");
        } finally {
            return 1;
        }
    }
}
