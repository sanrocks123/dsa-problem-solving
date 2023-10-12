/* (C) 2023 */
package dsa;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
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

        Deque<Integer> deque = new LinkedBlockingDeque<>(3);
        Set<Integer> hashTable = new LinkedHashSet<>();

        Integer[] pages = {2, 3, 4, 2, 5, 4, 3};
        System.out.printf("pages : %s", Arrays.stream(pages).toList());

        for (Integer page : pages) {

            System.out.printf("\n\npageNo : %d", page);
            System.out.printf("\ncache status : %s", deque);
            System.out.printf("\nhash status: %s", hashTable);

            if (hashTable.contains(page)) {
                System.out.printf("\ncache hit - %d", page);
                if (deque.remove(page)) {
                    deque.push(page);
                }
                System.out.printf("\ncache status : %s", deque);
                System.out.printf("\nhash status: %s", hashTable);

            } else {
                System.out.printf("\ncache miss - %d", page);
                if (deque.size() == 3) {
                    Integer lruInteger = deque.removeLast();
                    hashTable.remove(lruInteger);
                }

                hashTable.add(page);
                deque.push(page);

                System.out.printf("\ncache status : %s", deque);
                System.out.printf("\nhash status: %s", hashTable);
            }
        }
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
