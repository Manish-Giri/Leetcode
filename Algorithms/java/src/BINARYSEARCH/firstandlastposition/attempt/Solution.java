package BINARYSEARCH.firstandlastposition.attempt;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * <p>
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */

class Solution {
    /**
     * Runtime
     * 0 ms
     * Beats
     * 100%
     * Memory
     * 48.4 MB
     * Beats
     * 5.52%
     *
     * @param nums
     * @param target
     * @return
     */
    int[] searchRange(int[] nums, int target) {
        int idx = binSearch(nums, target);
        if (idx == -1) return new int[]{-1, -1};
        int leftPos = idx, rightPos = idx;
        while ((leftPos - 1 >= 0) && nums[leftPos - 1] == target) leftPos--;
        while ((rightPos + 1 < nums.length) && nums[rightPos + 1] == target) rightPos++;
        return new int[]{leftPos, rightPos};
    }

    int binSearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else {
                if (target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }

        }
        return -1;
    }
}
