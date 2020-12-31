package threeconsecutiveodds.hashmap;

import java.util.HashMap;

/**
 * Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
 *
 *
 * Example 1:
 *
 * Input: arr = [2,6,4,1]
 * Output: false
 * Explanation: There are no three consecutive odds.
 * Example 2:
 *
 * Input: arr = [1,2,34,3,4,5,7,23,12]
 * Output: true
 * Explanation: [5,7,23] are three consecutive odds.
 */

class Solution {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Three Consecutive Odds.
     * Memory Usage: 38.5 MB, less than 79.05% of Java online submissions for Three Consecutive Odds.
     *
     * @param arr
     * @return
     */
    boolean threeConsecutiveOdds(int[] arr) {

        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
        }

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 == 0)
                continue;
            else {
                if (map.get(i + 1) % 2 != 0 && map.get(i + 2) % 2 != 0) {
                    return true;
                } else
                    continue;
            }
        }

        return false;
    }
}
