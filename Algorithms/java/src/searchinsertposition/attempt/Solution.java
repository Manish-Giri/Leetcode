package searchinsertposition.attempt;

class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
     * Memory Usage: 38.6 MB, less than 71.26% of Java online submissions for Search Insert Position.
     *
     * @param nums
     * @param target
     * @return
     */
    int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;

    }
}
