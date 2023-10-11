/* (C) 2017 */
package designpatterns;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source Singleton.java created on Nov 27, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class Singleton implements Cloneable {

    private static volatile Singleton singleton = null;
    private static final Logger log = LoggerFactory.getLogger(Singleton.class);

    /** */
    public static Singleton getInstance() {

        log.info("started");
        if (Objects.isNull(singleton)) {
            synchronized (Singleton.class) {
                if (Objects.isNull(singleton)) {
                    log.info("Lock acquired, initializing singleton");
                    singleton = new Singleton();
                    log.info("singleton created, hashCode: {}", singleton.hashCode());
                }
            }
        }
        log.info("singleton reused, hashCode: {}", singleton.hashCode());
        return singleton;
    }

    /** */
    private Singleton() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Singleton clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
