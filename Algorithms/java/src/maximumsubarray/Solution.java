package maximumsubarray;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class Solution {
    // this is the greedy approach
    public int maxSubArray(int[] nums) {
        int currSum = nums[0], maxSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}

/*
Success
Details
Runtime: 1 ms, faster than 82.25% of Java online submissions for Maximum Subarray.
Memory Usage: 41.6 MB, less than 5.16% of Java online submissions for Maximum Subarray.
 */