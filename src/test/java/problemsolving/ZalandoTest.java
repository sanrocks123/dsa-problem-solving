/* (C) 2023 */
package problemsolving;

import java.util.*;
import org.junit.jupiter.api.Test;

/**
 * Java Source ZalandoTest.java created on Oct 9, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */
public class ZalandoTest {

    @Test
    public void test1() {

        // 50552 = 50, 05, 55, 52 -> 55

        final String s = "50552";
        int maxSoFar = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            j = i + 2;
            if (j >= s.length() + 1) {
                break;
            }
            final String temp = s.substring(i, j);
            System.out.println("temp: " + temp);
            System.out.println("maxSoFar: " + maxSoFar);

            final int currentNumber = Integer.valueOf(temp);
            if (currentNumber > maxSoFar) {
                maxSoFar = currentNumber;
            }
        }

        System.out.println("max: " + maxSoFar);
    }

    @Test
    public void test2() {

        final String s = "abccbd";
        final int[] c = {0, 1, 2, 3, 4, 5};

        final Map<Character, PriorityQueue<Integer>> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            final char cc = s.charAt(i);
            final int j = i;

            countMap.computeIfPresent(
                    cc,
                    (k, v) -> {
                        v.add(c[j]);
                        return v;
                    });

            countMap.computeIfAbsent(
                    cc,
                    v -> {
                        final PriorityQueue<Integer> list = new PriorityQueue<>();
                        list.add(c[j]);
                        return list;
                    });
        }

        System.out.println("countMap: " + countMap);
        final List<Integer> minCostList = new ArrayList<>();

        final char[] cArr = s.toCharArray();
        int prev = 0;
        for (int i = 1; i < cArr.length; i++) {

            // System.out.println("prev char: " + cArr[prev]);
            // System.out.println("current char: " + cArr[i]);

            if (cArr[i] == cArr[prev]) {
                System.out.println("consecutiive char found: " + prev + "," + i);
                minCostList.add(countMap.get(cArr[i]).poll());
                System.out.println("minCostSoFar: " + minCostList);
            }
            prev = i;
        }

        final int minCostSum = minCostList.stream().mapToInt(v -> v.intValue()).sum();
        System.out.println("minCost: " + minCostSum);
    }

    @Test
    public void test3() {

        final int[] a = {5, 2, 4, 6, 3, 7};

        int minSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {

            for (int j = i + 2; j < a.length; j++) {

                final int currentSum = a[i] + a[j];
                System.out.println(String.format("a[%d] + a[%d] = %d", i, j, currentSum));

                if (currentSum < minSoFar) {
                    minSoFar = currentSum;
                    System.out.println(String.format("i:%d, j:%d, minSoFar: %d", i, j, minSoFar));
                }
            }
        }
        System.out.println(minSoFar);
    }
}
