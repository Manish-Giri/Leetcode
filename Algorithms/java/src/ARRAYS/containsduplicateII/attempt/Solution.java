package ARRAYS.containsduplicateII.attempt;
import java.util.*;

/**
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 */
 class Solution {

     /**
      * Runtime
      * Details
      * 57ms
      * Beats 10.61%of users with Java
      * Memory
      * Details
      * 59.84MB
      * Beats 6.58%of users with Java
      *
      * @param nums
      * @param k
      * @return
      */
     private static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            }
            else {
                List<Integer> newVal = new ArrayList<>();
                newVal.add(i);
                map.put(nums[i], newVal);
            }
        }
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            if(entry.getValue().size() > 1) {
                int[] vals = entry.getValue().stream().mapToInt(x -> x).toArray();
                for(int i = 0; i < vals.length-1; i++) {
                    for(int j = i+1; j < vals.length; j++) {
                        if(Math.abs(vals[i] - vals[j]) <= k) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

     public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k)); // true

        nums = new int[]{1, 0, 1, 1};
        k = 1;
        System.out.println(containsNearbyDuplicate(nums, k)); // true
    }

}
