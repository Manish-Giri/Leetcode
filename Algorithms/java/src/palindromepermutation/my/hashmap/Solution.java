package palindromepermutation.my.hashmap;

import java.util.HashMap;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "code"
 * Output: false
 * Example 2:
 * <p>
 * Input: "aab"
 * Output: true
 * Example 3:
 * <p>
 * Input: "carerac"
 * Output: true
 */

class Solution {
    /**
     * Runtime: 1 ms, faster than 56.48% of Java online submissions for Palindrome Permutation.
     * Memory Usage: 36.7 MB, less than 78.92% of Java online submissions for Palindrome Permutation.
     *
     * @param s
     * @return
     */
    boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // for even length string, no character can have odd frequency
        // for odd length string, only one character can have odd frequency
        // otherwise not a palindrome
        boolean isEven = s.length() % 2 == 0;
        boolean oneCount = false;
        for (var curr : count.entrySet()) {
            int n = curr.getValue();
            if (n % 2 == 0) {
                continue;
            } else {
                if (isEven) {
                    return false;
                } else {
                    if (oneCount)
                        return false;
                    else
                        oneCount = true;
                }
            }

        }
        return true;
    }
}
