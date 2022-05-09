package ARRAYS.productofarrayexceptself.attempts.first;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * <p>
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * <p>
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */

import java.util.Arrays;

/**
 * APPROACH - Use additional space (2 extra arrays for holding left and right products)
 * Time - O(n), Space - O(n)
 */
class Solution {
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
     * Memory Usage: 51 MB, less than 75.02% of Java online submissions for Product of Array Except Self.
     */
    int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];
        left[0] = 1;
        int total = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = total * nums[i - 1];
            total = left[i];
        }
        right[right.length - 1] = 1;
        total = 1;
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = total * nums[i + 1];
            total = right[i];
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
