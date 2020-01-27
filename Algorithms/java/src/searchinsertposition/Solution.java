package searchinsertposition;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 */

class Solution {

    public int searchInsert(int[] nums, int target) {
        return recBinSearch(nums, 0, nums.length - 1, target);
    }

    private int recBinSearch(int[] nums, int low, int high, int target) {
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (low > high) {
            return low;
        } else if (target < nums[mid]) {
            return recBinSearch(nums, low, mid - 1, target);
        } else if (target > nums[mid]) {
            return recBinSearch(nums, mid + 1, high, target);
        }
        return -1;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
Memory Usage: 40.9 MB, less than 5.41% of Java online submissions for Search Insert Position.

 */