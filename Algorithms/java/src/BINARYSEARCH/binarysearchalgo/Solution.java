package BINARYSEARCH.binarysearchalgo;

/**
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 * Note:
 *
 * You may assume that all elements in nums are unique.
 * n will be in the range [1, 10000].
 * The value of each element in nums will be in the range [-9999, 9999].
 */

class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
     * Memory Usage: 40.3 MB, less than 10.21% of Java online submissions for Binary Search.
     *
     * Time - O(log n) | Space - O(log n)
     */
    int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    private int helper(int[] array, int target, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;  // to prevent overflow
        if (array[mid] == target) return mid;
        else if (target < array[mid]) return helper(array, target, low, mid - 1);
        else return helper(array, target, mid + 1, high);
    }

}
