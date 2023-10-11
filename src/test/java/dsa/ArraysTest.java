package dsa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Java Source ArraysTest.java created on Jun 5, 2021
 *
 * @author : Sanjeev Saxena
 * @version : 1.0
 * @email : sanrocks123@gmail.com
 */
public class ArraysTest {

    @Test
    public void testSubarrayWithGivenSum() {

        List<Integer> arr = List.of(1, 2, 3, 4, 5);
        int targetSum = 12;

        List<Integer> expected = List.of(2, 4);
        int currentSum = 0;
        int start = 0;

        for (int i = 1; i < arr.size(); i++) {

            // calculate  current sum
            currentSum += arr.get(i); //

            if (currentSum > targetSum) {
                currentSum -= arr.get(start);
                start++;
                continue;
            }
        }
    }

    @Test
    public void testArrayAlternateSorting() {
        final Integer[] arr = {1, 2, 3, -4, -1, 4};

        Arrays.sort(arr);
        System.out.printf("sorted array: %s", (Object) arr);

        int posStartIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                posStartIdx = i;
                break;
            }
        }
        int j = posStartIdx;
        for (int i = 0; i < posStartIdx; i++) {

            if (i % 2 == 0) {
                if (arr[i] > 0) {
                    final int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j++;
                }
            } else {
                if (arr[i] < 0) {
                    final int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j++;
                }
            }
        }

        System.out.println("\n");
        for (final int a : arr) {
            System.out.print(a);
        }
    }

    @Test
    public void testCountSubArray() {

        final int[] arr = {3, 4, 1, 6, 2};
        final int[] output = {1, 3, 1, 5, 1};

        final int[] result = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = 1;
            for (int j = i - 1; j < i; j--) {
                if (j < 0 || arr[j] > arr[i]) {
                    break;
                }
                count++;
            }

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    break;
                }
                count++;
            }
            result[i] = count;
        }

        Assertions.assertArrayEquals(output, result);
    }

    @Test
    public void testDuplicateNumbers() {

        final int arr[] = {1, 2, 3, 1, 3, 6, 6};

        for (int i = 0; i < arr.length; i++) {
            final int j = Math.abs(arr[i]);
            if (arr[j] >= 0) {
                arr[j] = -arr[j];
            } else {
                System.out.println(j + " ");
            }
        }
    }

    @Test
    public void testLargestNumberFormed() {
        final int arr[] = {1, 34, 3, 98, 9, 76, 45, 4};

        final List<String> arrList =
                Arrays.stream(arr).mapToObj(a -> String.valueOf(a)).collect(Collectors.toList());

        Collections.sort(
                arrList,
                (o1, o2) -> {
                    final String a = o1 + o2;
                    final String b = o2 + o1;
                    return a.compareTo(b) > 0 ? -1 : 1;
                });

        System.out.printf("expected: [998764543431], actual: [%s]", arrList);
    }

    // Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
    // Output: 4

    @Test
    public void testLargestSumContigousSubarray() {

        final int a[] = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};

        int sum = 0;
        int currentSum = 0;
        for (final int element : a) {
            currentSum = currentSum + element;

            if (currentSum > sum) {
                sum = currentSum;
            }

            if (currentSum <= 0) {
                currentSum = 0;
            }
        }
        System.out.printf("sum: %s", sum);
    }

    @Test
    public void testProductArrayPuzzleTest() {

        final int a[] = new int[] {10, 3, 5, 6, 2};
        final int r[] = new int[a.length];
        for (int i = 0; i <= a.length - 1; i++) {

            r[i] = findProduct(a, 0, i - 1) * findProduct(a, i + 1, a.length - 1);
        }

        for (int i = 0; i <= r.length - 1; i++) {
            System.out.printf("a[%s] : %s", i, r[i]);
        }
    }

    @Test
    public void testReverse() {

        final int a[] = new int[] {1, 2, 3, 4, 5};

        for (final Integer i : a) {
            System.out.printf("before reversal : %s", i);
        }

        for (int i = 0, j = a.length - 1; i != j; i++, j--) {
            final int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }

        for (final Integer i : a) {
            System.out.printf("after reversal : %s", i);
        }
    }

    @Test
    public void testSeggregateEvenOdd() {

        final int[] arr = {1, 2, 3, 4, 5, 6};

        int prevOdd = -1;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] % 2 == 0) {
                prevOdd++;
                final int temp = arr[prevOdd];
                arr[prevOdd] = arr[i];
                arr[i] = temp;
            }
        }

        for (final int e : arr) {
            System.out.print(e);
        }
    }

    /**
     * @param i
     * @param j
     * @return
     */
    private int findProduct(int[] a, int i, int j) {
        if (i > a.length - 1 || j < 0) {
            return 1;
        }

        int result = 1;
        for (int k = i; k <= j; k++) {
            result = result * a[k];
        }

        return result;
    }
}
