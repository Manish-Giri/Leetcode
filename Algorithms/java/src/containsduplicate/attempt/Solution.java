package containsduplicate.attempt;

import java.util.HashMap;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

class Solution {
    /**
     * Runtime: 23 ms, faster than 5.56% of Java online submissions for Contains Duplicate.
     * Memory Usage: 53 MB, less than 13.01% of Java online submissions for Contains Duplicate.
     *
     * @param nums
     * @return
     */
    boolean containsDuplicate(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int n : nums) {
            if (map.get(n) > 1)
                return true;
        }
        return false;
    }
}
