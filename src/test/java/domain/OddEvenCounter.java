/* (C) 2019 */
package domain;

import java.util.concurrent.TimeUnit;

/**
 * Java Source OddEvenCounter.java created on Jan 3, 2020
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class OddEvenCounter {

    private int count;
    private final int max;

    /**
     * @param maxCapacity
     * @param i
     */
    public OddEvenCounter(int count, int maxCapacity) {
        this.count = count;
        this.max = maxCapacity;
    }

    /**
     * @throws InterruptedException
     */
    @Override
    public void finalize() {
        System.out.println("finalize, OddEvenCounter object is about to be garbage collected");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("done with clean up");
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    public int getMax() {
        return this.max;
    }

    public boolean isMaxCapacityReached() {
        return this.count > max;
    }

    /** */
    public synchronized int printEven() {
        while (count % 2 != 0) {
            waitt();
        }
        return update();
    }

    /** */
    public synchronized int printOdd() {
        while (count % 2 == 0) {
            waitt();
        }
        return update();
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return
     */
    private int update() {
        final int value = count;
        count++;
        notify();
        return value;
    }

    /** */
    private void waitt() {
        try {
            wait();
        } catch (final InterruptedException e) {
            throw new RuntimeException(String.format("Error running waiting", e.getMessage()), e);
        }
    }
}
