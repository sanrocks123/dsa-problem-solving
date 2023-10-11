/* (C) 2017 */
package designpatterns;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Java Source SingletonEnum.java created on Nov 27, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public enum SingletonEnum {
    INSTANCE,
    AA("aa");

    private AtomicInteger value;

    /** */
    private SingletonEnum() {
        try {
            TimeUnit.SECONDS.sleep(5);
            value = new AtomicInteger();
            System.out.println(
                    String.format(
                            "[%s] SingletonEnum created, hashCode: %s",
                            Thread.currentThread().getName(), value.hashCode()));
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

    private SingletonEnum(String aa) {}

    /**
     * @return
     */
    public AtomicInteger getAtomicInteger() {
        System.out.println(
                String.format(
                        "[%s] SingletonEnum reused, hashCode: %s",
                        Thread.currentThread().getName(), value.hashCode()));
        return value;
    }
}
