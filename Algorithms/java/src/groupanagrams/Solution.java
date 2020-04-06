package groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

 class Solution {

     /**
      * Approach 1 - Categorize by Sorted String
      * Intuition - Two strings are anagrams if and only if their sorted strings are equal.
      *
      * Runtime: 6 ms, faster than 96.85% of Java online submissions for Group Anagrams.
      * Memory Usage: 42.7 MB, less than 81.87% of Java online submissions for Group Anagrams.
      *
      * Runtime: 16 ms, faster than 26.04% of Java online submissions for Group Anagrams.
      * Memory Usage: 53.7 MB, less than 5.26% of Java online submissions for Group Anagrams.
      *
      * Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs.
      * The outer loop has complexity O(N) as we iterate through each string. Then we sort each string in O(KlogK) time.
      * Space Complexity: O(NK), the total information content stored in ans
      */
     List<List<String>> groupAnagrams_ApproachOne(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word: strs) {
            char[] temp = word.toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);
            if(map.containsKey(sorted)) {
                map.get(sorted).add(word);
            }
            else {
                List<String> curr = new ArrayList<>();
                curr.add(word);
                map.put(sorted, curr);
            }
        }
        return new ArrayList<>(map.values());
    }

}
