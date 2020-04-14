package performstringshifts;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 * <p>
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * Example 2:
 * <p>
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * 0 <= shift[i][0] <= 1
 * 0 <= shift[i][1] <= 100
 */

class Solution {
    /**
     * Runtime: 3 ms
     * Memory Usage: 37.8 MB
     */
    String stringShift(String s, int[][] shift) {
        ArrayDeque<String> ad = new ArrayDeque<>(Arrays.asList(s.split("")));
        int dir = 0, amount = 0;
        for (int[] op : shift) {
            dir = op[0];
            amount = op[1];
            for (int i = 0; i < amount; i++) {
                if (dir == 0)
                    ad.addLast(ad.pollFirst());
                else
                    ad.addFirst(ad.pollLast());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String temp : ad.toArray(String[]::new))
            sb.append(temp);
        return sb.toString();

    }
}
