package runningsumof1Darray;

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * <p>
 * Return the running sum of nums.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,1,1]
 * Output: [1,2,3,4,5]
 * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
 * Example 3:
 * <p>
 * Input: nums = [3,1,2,10,1]
 * Output: [3,4,6,16,17]
 */

class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Running Sum of 1d Array.
     * Memory Usage: 39.4 MB, less than 19.57% of Java online submissions for Running Sum of 1d Array.
     *
     * @param nums
     * @return
     */
    int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            result[i] = curr;
        }
        return result;

    }
}
