package rotatearray;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */

class Solution {
    void rotate(int[] nums, int k) {
        for(int i = 0; i < k; i++)
            rotateRightOnce(nums);
    }

    private void rotateRightOnce(int[] nums) {
        int lastIdx = nums.length-1;
        int last = nums[lastIdx];
        for(int i = lastIdx; i > 0; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = last;
    }
}

/*
Runtime: 195 ms, faster than 7.14% of Java online submissions for Rotate Array.
Memory Usage: 42.1 MB, less than 5.77% of Java online submissions for Rotate Array.
 */