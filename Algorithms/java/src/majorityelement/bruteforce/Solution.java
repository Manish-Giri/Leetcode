package majorityelement.bruteforce;

import java.util.HashMap;

/*

 */

 class Solution {
    
    /**
     * Runtime: 13 ms, faster than 11.44% of Java online submissions for Majority Element.
     * Memory Usage: 53.6 MB, less than 6.30% of Java online submissions for Majority Element.
     * Time - O(n) | Space - O(n)
    */
    
     int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        int majority = nums.length/2;
        for(var pair: count.entrySet()) {
            if(pair.getValue() > majority)
                return pair.getKey();
        }
        return -1;
    }

}
