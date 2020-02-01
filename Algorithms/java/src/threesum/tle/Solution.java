package threesum.tle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */


// TODO: Time Limit Exceeded for very large arrays
// Current implementation - O(nlogn)

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        // sort nums
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            int first = nums[i];
            int diff = 0 - first;
            List<List<Integer>> twoElemPairs = twoSum(nums, i+1, nums.length-1, diff);
            if(!twoElemPairs.isEmpty()) {
                for(List<Integer> pair: twoElemPairs) {
                    pair.add(first);
                    // add this AL if not already present in triplets
                    if(!triplets.contains(pair))
                        triplets.add(pair);
                }

            }
        }
        return triplets;
    }

    private List<List<Integer>> twoSum(int[] nums, int i, int j, int target) {
        List<List<Integer>> elements = new ArrayList<>();
        while(i < j) {
            if(nums[i] + nums[j] == target) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[i]);
                pair.add(nums[j]);
                elements.add(pair);
                i++;
                j--;
            }
            else if(nums[i] + nums[j] < target) {
                i++;
            }
            else {
                j--;
            }
        }
        return elements;
    }
}
