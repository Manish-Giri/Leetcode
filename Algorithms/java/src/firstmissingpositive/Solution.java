package firstmissingpositive;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 */

 class Solution {

     int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean is1Present = false;
        for(int x: nums) {
            if(x == 1) {
                is1Present = true;
                break;
            }
        }
        if(!is1Present)
            return 1;
        
        // in case when nums = [1]
        if(n == 1)
            return 2;

        // change -ve elements, 0 and elems > n to 1
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // for every elem x, go to nums[x] and change sign to -ve if not already -ve
        for(int i = 0; i < nums.length; i++) {
            int elem = Math.abs(nums[i]);
            // since there is no nth element in array of n elements, store this info in index 0
            if(elem == n) {
                nums[0] = -n;
            }
            // otherwise in nums[x] for elem x
            else if(nums[elem] > 0) {
                nums[elem] = -nums[elem];
            }
        }

        for(int i = 1; i < nums.length; i++) {
            // return first index which is +ve
            if(nums[i] > 0)
                return i;
        }

        // if all indices from 1 onwards is -ve, check 0th index
        if(nums[0] > 0)
            return n;

        // in case all elems present, first missing is next after n
        return n+1;
    }
}

/*
Success
Details
Runtime: 0 ms, faster than 100.00% of Java online submissions for First Missing Positive.
Memory Usage: 38 MB, less than 6.85% of Java online submissions for First Missing Positive.
 */