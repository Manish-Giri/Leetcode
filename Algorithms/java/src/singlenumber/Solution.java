package singlenumber;

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */

class Solution {
    public int singleNumber(int[] nums) {
        int x = nums[0];
        for(int i = 1; i < nums.length; i++)
            x ^= nums[i];
        return x;
    }

}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number.
Memory Usage: 42.3 MB, less than 5.19% of Java online submissions for Single Number.
 */