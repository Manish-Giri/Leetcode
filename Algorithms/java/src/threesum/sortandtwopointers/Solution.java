package threesum.sortandtwopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * <p>
 * Input: nums = []
 * Output: []
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */

class Solution {

    /**
     * APPROACH - SORT and use TWO POINTERS
     * Runtime: 335 ms, faster than 21.86% of Java online submissions for 3Sum.
     * Memory Usage: 42.9 MB, less than 92.55% of Java online submissions for 3Sum.
     *
     * @param nums
     * @return
     */
    List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hs = new HashSet<>();
        int left, right, cSum;

        for (int start = 0; start < nums.length - 1; start++) {
            left = start + 1;
            right = nums.length - 1;

            while (left < right) {
                cSum = nums[start] + nums[left] + nums[right];

                if (cSum == 0) {
                    List<Integer> temp = List.of(nums[start], nums[left], nums[right]);
                    //al.add(temp);
                    hs.add(temp);
                    left++;
                    right--;
                }
                else {
                    if (cSum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

        }
        return new ArrayList<>(hs);
    }
}
