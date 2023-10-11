/* (C) 2023 */
package dsa;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

/**
 * Java Source QueueTest.java created on Aug 12, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class QueueTest {

    @Test
    public void testLRUCache() {

        final Deque<Integer> dq = new LinkedList<>();

        System.out.println(dq);
    }

    @Test
    public void testQueue() {

        // arr = [1, 2, 2, 3, 4, 5]

        final Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(1);
        queue.add(4);

        System.out.println(queue);
    }
}
