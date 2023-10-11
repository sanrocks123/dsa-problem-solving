/* (C) 2023 */
package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * Java Source HashingProblemTest.java created on Jul 22, 2021
 *
 * @author : Sanjeev Saxena
 * @version : 1.0
 * @email : sanrocks123@gmail.com
 */
public class HashingTest {

    @Test
    public void testDistinctElementInEvryWindowOfSizeK() {

        final int arr[] = {1, 2, 1, 3, 4, 2, 3};
        System.out.println("i/p list : " + Arrays.stream(arr).boxed().collect(Collectors.toList()));

        final Map<Integer, Integer> hm = new HashMap<>();

        final int window = 4;
        for (int i = 0; i < window; i++) {
            hm.computeIfPresent(arr[i], (k, v) -> v + 1);
            hm.computeIfAbsent(arr[i], v -> 1);
        }

        System.out.println(hm.size());

        for (int i = window; i < arr.length; i++) {

            final int prev = i - window;

            if (hm.get(arr[prev]) == 1) {
                hm.remove(arr[prev]);
            } else {
                hm.put(arr[prev], hm.get(arr[prev]) - 1);
            }

            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            System.out.println(hm.size());
        }
    }

    @Test
    public void testHashMap() {

        final int[] arr = {1, 1, 2, 3, 2};

        final Map<Integer, Integer> map = new HashMap<>();

        for (final int e : arr) {
            map.computeIfPresent(e, (k, v) -> v + 1);
            map.computeIfAbsent(e, v -> 1);
        }
        System.out.println(map);

        final String s = "Listen";
        final String s1 = "Silent";

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum + s.charAt(i) - s1.charAt(i);
            System.out.println(sum);
        }
        System.out.printf("count : %s", sum);
    }

    @Test
    public void testLongestConsecutiveSubsequence() {
        final Set<Integer> hash = new HashSet<>();
        final int arr[] = {1, 9, 3, 10, 4, 20, 2};
        for (final int a : arr) {
            hash.add(a);
        }

        int maxCount = Integer.MIN_VALUE;
        for (final int a : arr) {

            // check for start sequence
            if (!hash.contains(a - 1)) {

                final int start = a;
                int next = start;
                int count = 0;

                while (hash.contains(next)) {
                    next++;
                    count++;
                }
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }
        System.out.printf("max count : %s", maxCount);
    }

    @Test
    public void testNonRepeatingFirstChar() {

        final String str = "GeeksForGeeks";
        final char[] cArr = str.toCharArray();

        final Map<String, Integer> map = new LinkedHashMap<>();
        for (final char c : cArr) {
            map.computeIfPresent(Character.valueOf(c).toString(), (k, v) -> v + 1);
            map.computeIfAbsent(Character.valueOf(c).toString(), a -> 1);
        }

        System.out.printf("map: %s", map);

        for (final Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                System.out.printf("first non repeating char: %s", entry.getKey());
                break;
            }
        }
    }

    @Test
    public void testNumberOfWays() {

        final int[] arr = {1, 2, 3, 4, 3};
        final int sum = 6;

        final Map<Integer, Integer> map = new HashMap<>();

        for (final int element : arr) {
            map.computeIfPresent(element, (k, v) -> v + 1);
            map.computeIfAbsent(element, v -> 1);
        }

        System.out.println(map);

        final Set<String> pairs = new HashSet<>();

        for (final int element : arr) {

            final int temp = sum - element;

            if (map.containsKey(temp)) {
                final int oldValue = map.get(temp);
                final int newValue = oldValue - 1;

                if (newValue == 0) {
                    map.remove(element);
                } else {
                    map.put(temp, newValue);
                }
                final String s = String.format("%s%s", element, temp);
                pairs.add(s);

                System.out.printf("pair found: %s\n", s);
            }
        }
        System.out.println(pairs);
    }

    /**
     * Input: N = 8 A[] = {15,-2,2,-8,1,7,10,23}
     *
     * <p>Output: 5
     *
     * <p>Explanation: The largest subarray with sum 0 will be -2 2 -8 1 7.
     */
    @Test
    public void testLargestSubarrayWithZeroSum() {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int prevSumFoundIndex = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (map.containsKey(sum)) {
                prevSumFoundIndex = map.get(sum);
                continue;
            }
            map.put(sum, i);
        }
    }

    /**
     * Example: Input: 5 5 4 6 4 9 9 9 2 5
     *
     * <p>Output: 4 4 5 5 6 9 9 9 2 5
     *
     * <p>Explanation: Testcase1: The highest frequency here is 2. Both 5 and 4 have that frequency.
     * Now since the frequencies are same then smaller element comes first. So 4 4 comes first then
     * comes 5 5. Finally comes 6. The output is 4 4 5 5 6.
     *
     * <p>Testcase2: The highest frequency here is 3. The element 9 has the highest frequency. So 9
     * 9 9 comes first. Now both 2 and 5 have same frequency. So we print smaller element first. The
     * output is 9 9 9 2 5.
     */
    @Test
    public void testSortArrayByFrequency() {
        Integer arr[] = {9, 9, 9, 2, 5};

        // done just for testing arrays sort operations
        Arrays.sort(arr, (x, y) -> y - x);
        Arrays.stream(arr).forEach(e -> System.out.printf("%s", e));

        // find element -> frequency count
        Map<Integer, Integer> element2frequencyMap = new HashMap<>();
        Arrays.stream(arr)
                .forEach(
                        e -> {
                            element2frequencyMap.computeIfPresent(e, (k, v) -> v + 1);
                            element2frequencyMap.computeIfAbsent(e, v -> 1);
                        });

        System.out.printf("frequencyMap: %s", element2frequencyMap);

        // create map of (TreeMap<DESC>)frequency -> elements (sorted elements)
        Map<Integer, List<Integer>> frequency2ElementMap = new TreeMap<>((x, y) -> y - x);

        element2frequencyMap.keySet().stream()
                .forEach(
                        key -> {
                            int frequency = element2frequencyMap.get(key);
                            frequency2ElementMap.computeIfPresent(
                                    frequency,
                                    (k, v) -> {
                                        v.add(key);
                                        return v;
                                    });

                            frequency2ElementMap.computeIfAbsent(
                                    frequency,
                                    v -> {
                                        List<Integer> list = new ArrayList();
                                        list.add(key);
                                        return list;
                                    });
                        });

        // print tree map
        System.out.printf("frequency2ElementMap: %s", frequency2ElementMap);
        List<Integer> output = new ArrayList<>();
        frequency2ElementMap.keySet().stream()
                .forEach(
                        key -> {
                            output.addAll(frequency2ElementMap.get(key));
                        });

        System.out.printf("output: %s", output);
    }

    /**
     * Given two lists V1 and V2 of sizes n and m respectively. Return the list of elements common
     * to both the lists and return the list in sorted order. Duplicates may be there in the output
     * list.
     *
     * <p>Example:
     *
     * <p>Input: n = 5 v1[] = {3, 4, 2, 2, 4} m = 4 v2[] = {3, 2, 2, 7} Output: 2 2 3 Explanation:
     * The common elements in sorted order are {2 2 3}
     */
    @Test
    public void testFindCommonElements() {
        // TODO
    }

    /**
     * Given an array of integers and another number. Find all the unique quadruple from the given
     * array that sums up to the given number.
     *
     * <p>Example 1:
     *
     * <p>Input: N = 5, K = 3 A[] = {0,0,2,1,1} Output: 0 0 1 2 $ Explanation: Sum of 0, 0, 1, 2 is
     * equal to K.
     */
    @Test
    public void testFindAllFourSumNumbers() {}
}
