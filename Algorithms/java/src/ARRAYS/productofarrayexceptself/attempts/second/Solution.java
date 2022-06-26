package ARRAYS.productofarrayexceptself.attempts.second;

// APPROACH - Uses constant space O(1)
// create result array - fill it with left/prefix product
// traverse result array R->L and compute the product for each index
// by using an int variable for right product and current value in that index for left product

class Solution {
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
     * Memory Usage: 50.2 MB, less than 95.37% of Java online submissions for Product of Array Except Self.
     */
    int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        int total = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = total * nums[i - 1];
            total = res[i];
        }
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
}
