package BINARYSEARCH.firstandlastposition.attempt1;

import java.util.Arrays;

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
    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int leftPos = binSearch(nums, target, true);
        if (leftPos == -1) return ans;
        int rightPos = binSearch(nums, target, false);
        ans = new int[]{leftPos, rightPos};
        return ans;
    }

    static int binSearch(int[] nums, int target, boolean isAsc) {
        int start = 0, end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) start = mid + 1;
            else if(target < nums[mid]) end = mid - 1;
            else {
                // found matching element, now look in left or right half for more occurrences
                ans = mid;
                if(isAsc) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,7,7,7,7,7,7,8,8,9,10};
        int[] res = searchRange(arr, 7);
        System.out.println(Arrays.toString(res));
    }
}
