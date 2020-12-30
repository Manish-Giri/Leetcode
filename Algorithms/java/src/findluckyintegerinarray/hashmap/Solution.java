package findluckyintegerinarray.hashmap;

import java.util.HashMap;

/**
 * Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.
 * <p>
 * Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [2,2,3,4]
 * Output: 2
 * Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
 * Example 2:
 * <p>
 * Input: arr = [1,2,2,3,3,3]
 * Output: 3
 * Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
 * Example 3:
 * <p>
 * Input: arr = [2,2,2,3,3]
 * Output: -1
 * Explanation: There are no lucky numbers in the array.
 * Example 4:
 * <p>
 * Input: arr = [5]
 * Output: -1
 * Example 5:
 * <p>
 * Input: arr = [7,7,7,7,7,7,7]
 * Output: 7
 */

class Solution {

    /**
     * Runtime: 3 ms, faster than 60.77% of Java online submissions for Find Lucky Integer in an Array.
     * Memory Usage: 38.5 MB, less than 86.39% of Java online submissions for Find Lucky Integer in an Array.
     *
     * @param arr
     * @return
     */
    int findLucky(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int largest = Integer.MIN_VALUE;
        for (var pair : map.entrySet()) {
            if (pair.getKey().equals(pair.getValue())) {
                if (pair.getKey() > largest) {
                    largest = pair.getKey();
                }
            }
        }
        return largest == Integer.MIN_VALUE ? -1 : largest;

    }
}
