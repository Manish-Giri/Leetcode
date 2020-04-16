package maxconsecutiveones;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 *
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * Note:
 *
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */

 class Solution {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Max Consecutive Ones.
     * Memory Usage: 41.1 MB, less than 7.84% of Java online submissions for Max Consecutive Ones.
     */
     int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0, consOnes = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                maxOnes = Math.max(consOnes, maxOnes);
                consOnes = 0;
            }
            else {
                consOnes++;
            }
        }
        // if no zeroes encountered in array
        return Math.max(consOnes, maxOnes);
    }

}
