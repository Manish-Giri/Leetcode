package backspacestringcompare;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * <p>
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * <p>
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * <p>
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 * <p>
 * Can you solve it in O(N) time and O(1) space?
 */

class Solution {

    /**
     * Approach 1 - Using stack
     * Time - O(n), Space - O(n)
     * <p>
     * Runtime: 1 ms, faster than 62.48% of Java online submissions for Backspace String Compare.
     * Memory Usage: 37.5 MB, less than 6.06% of Java online submissions for Backspace String Compare.
     */
    boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = stackBuilder(S);
        Stack<Character> s2 = stackBuilder(T);
        return s1.size() == s2.size() && String.valueOf(s1).equals(String.valueOf(s2));
    }

    private Stack<Character> stackBuilder(String str) {
        Stack<Character> s = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(c);
            }
        }
        return s;
    }
}
