/* (C) 2023 */
package dsa;

import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class DynamicProgrammingTest {

    /**
     * Input: l = 11, p = 2, q = 3, r = 5 Output: 5 Segments of 2, 2, 2, 2 and 3
     *
     * <p>Input: l = 7, p = 2, q = 5, r = 5 Output: 2 Segments of 2 and 5
     */
    @Test
    public void testMaximizeCutSegments() {
        // int arr[] = {11, 2, 3, 5};
        // int arr[] = {7, 2, 5, 5};

        int arr[] = {4, 2, 1, 1};

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < arr.length; i++) {
            map.put(arr[i], new ArrayList<>());
        }

        int max =
                map.keySet().stream()
                        .mapToInt(
                                k -> {
                                    return findMaxCuts(arr[0], k, map);
                                })
                        .max()
                        .getAsInt();

        System.out.printf("max cuts: %s", max);
    }

    private int findMaxCuts(final int n, final Integer k, final Map<Integer, List<Integer>> map) {

        map.compute(
                k,
                (x, y) -> {
                    y.add(n);
                    return y;
                });

        int remainder = n - k;
        if (remainder <= 0) {
            return 0;
        }
        findMaxCuts(n - k, k, map);

        // if last remainder is not part of given cut sizes, then set current cut size to 0
        List<Integer> values = map.get(k);
        if (!values.isEmpty() && !map.containsKey(values.get(values.size() - 1))) {
            map.put(k, Collections.emptyList());
        }

        System.out.printf("k : [%s], map: %s", k, map);
        return map.get(k).size();
    }

    /**
     * Input: N = 5 P[] = {5 24 , 39 60 , 15 28 , 27 40 , 50 90}
     *
     * <p>Output: 3
     *
     * <p>Explanation: The given pairs are { {5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} },the
     * longest chain that can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, {50,
     * 90}}
     */
    @Test
    public void testFindMaxLengthChain() {
        // TODO
    }

    @Test
    public void testMinCoins() {
        int coins[] = {9, 6, 5, 1};
        int V = 11;
        System.out.printf("Minimum coins required is " + minCoins(coins, V));
    }

    private int minCoins(int coins[], int V) {

        System.out.printf(
                "v=%s, coins: %s", V, Arrays.stream(coins).boxed().collect(Collectors.toList()));

        // base case
        if (V == 0) {
            System.out.print("V is 0, returning from stack...");
            return 0;
        }

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than V
        for (int i = 0; i < coins.length; i++) {

            if (coins[i] <= V) {

                System.out.printf("found coin %s <= V %s", coins[i], V);
                int sub_res = minCoins(coins, V - coins[i]);

                // Check for INT_MAX to avoid overflow and see if
                // result can minimized
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
                    res = sub_res + 1;
                }
                System.out.printf("i: %s, v:%s, res: %s", i, V, res);
            }
        }
        System.out.printf("return res: %s", res);
        return res;
    }
}
