package permutations.recursivebruteforce;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */

 class Solution {

     /**
      * Runtime: 1 ms, faster than 92.63% of Java online submissions for Permutations.
      * Memory Usage: 39.1 MB, less than 73.36% of Java online submissions for Permutations.
      *
      * @param nums
      * @return
      */
     List<List<Integer>> permute(int[] nums) {
        var perms = new ArrayList<List<Integer>>();
        var perm = new ArrayList<Integer>();
        List<Integer> array = new ArrayList<>();
        for(int n: nums) array.add(n);
        helper(array, perm, perms);
        return perms;
    }

    private void helper(List<Integer> array, List<Integer> perm, List<List<Integer>> perms) {
        // base case - when array is empty and curr perm is not empty
        if(array.isEmpty() && !perm.isEmpty()) {
            perms.add(perm);
            return;
        }

        // recursive call for each num in array - [1,2,3]
        for(int i = 0; i < array.size(); i++) {
            // create copy of array and remove element at index i
            List<Integer> arr = new ArrayList<>(array);
            int removed = arr.remove(i);
            // add element removed to current perm built built
            List<Integer> currPerm = new ArrayList<>(perm);
            currPerm.add(removed);
            // recursive call with new array, new perm copy
            helper(arr, currPerm, perms);
        }

    }
}
