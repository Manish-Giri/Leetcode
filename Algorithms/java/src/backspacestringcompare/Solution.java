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
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            } else {
                s1.push(c);
            }
        }

        for (char c : T.toCharArray()) {
            if (c == '#') {
                if (!s2.isEmpty()) {
                    s2.pop();
                }
            } else {
                s2.push(c);
            }
        }
        if (s1.size() != s2.size()) return false;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.pop() != s2.pop())
                return false;
        }
        return true;
    }
}
