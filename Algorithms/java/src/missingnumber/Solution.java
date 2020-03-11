package missingnumber;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

 class Solution {
     int missingNumber(int[] nums) {
        int total = 0;
        for(int i: nums) total += i;
        int len = nums.length;
        int summation = len*(len+1)/2;
        return summation - total;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number.
Memory Usage: 42.8 MB, less than 5.26% of Java online submissions for Missing Number.
 */