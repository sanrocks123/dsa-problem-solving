package dsa;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * Java Source HeapTest.java created on Aug 11, 2021
 *
 * @author : Sanjeev Saxena
 * @version : 1.0
 * @email : sanrocks123@gmail.com
 */
public class HeapTest {

    @Test
    public void testKLargestElements() {

        final int arr[] = {4, 10, 3, 5, 1};
        final int k = 3;

        final List<Integer> inputArr = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println("inputArr : " + inputArr);

        final PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            minheap.add(arr[i]);
        }

        System.out.printf("first 3 elements in heap: %s\n", minheap);

        for (int i = k; i < arr.length; i++) {
            if (minheap.peek() > arr[i]) {
                continue;
            } else {
                minheap.poll();
                minheap.add(arr[i]);
            }
        }

        System.out.printf("max 3 elements : %s\n", minheap);

        System.out.println(1 / 2);
    }

    @Test
    public void testNewClassModelling() {

        for (int i = 0; i <= 100; i++) {
            System.out.println("Never");
        }
    }
}
