package contiguousarray;

import java.util.HashMap;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */

class Solution {

    /**
     * Runtime: 20 ms, faster than 79.10% of Java online submissions for Contiguous Array.
     * Memory Usage: 49.4 MB, less than 100.00% of Java online submissions for Contiguous Array.
     */
    int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

    /**
     * Approach - Brute Force
     * consider every possible subarray within the given array and count the number of zeros and ones in each subarray.    * Then, we find out the maximum size subarray with equal no. of zeros and ones out of them.
     * TLE
     */
    int findMaxLength_ApproachOne(int[] nums) {
        int maxLen = 0, currLen = 0;
        for (int start = 0; start < nums.length; start++) {
            int z = 0, o = 0;
            for (int end = start; end < nums.length; end++) {
                if (nums[end] == 0) z++;
                else o++;
                if (z == o)
                    maxLen = Math.max(maxLen, end - start + 1);
            }

        }
        return maxLen;
    }
}
