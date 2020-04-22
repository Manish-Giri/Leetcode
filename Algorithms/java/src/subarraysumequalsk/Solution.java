package subarraysumequalsk;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */

class Solution {

    /**
     * Approach 1 - Brute Force
     * <p>
     * Runtime: 211 ms, faster than 19.76% of Java online submissions for Subarray Sum Equals K.
     * Memory Usage: 40.3 MB, less than 36.95% of Java online submissions for Subarray Sum Equals K.
     */
    int subarraySum(int[] nums, int k) {
        int num = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            for (int j = i + 1; j <= nums.length; j++) {
                if (sum == k) num++;
                if (j >= nums.length) break;
                sum += nums[j];
            }
        }
        return num;

    }
}
