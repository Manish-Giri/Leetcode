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
    boolean backspaceCompare_ApproachOne(String S, String T) {
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

    /**
     * Approach - two pointer
     * Iterate through the string in reverse. If we see a backspace character, the next non-backspace character    * is skipped. If a character isn't skipped, it is part of the final answer.
     * Time Complexity: O(M + N). Space Complexity : O(1)
     * <p>
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Backspace String Compare.
     * Memory Usage: 37.8 MB, less than 6.06% of Java online submissions for Backspace String Compare.
     */
    boolean backspaceCompare_ApproachTwo(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1, skipS = 0, skipT = 0;
        // iterate from reverse
        while (i >= 0 || j >= 0) {
            // look for first usable character in S
            while (i >= 0) {
                // case 1 - if # char - incr count of bckspace (skipS), and decr i
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                }
                // case 2 - if not a # char, and # has been encountered earlier,
                // then ignore as many bckspace chars as has been accumulated in skipS so far, and decr it
                else if (skipS > 0) {
                    skipS--;
                    i--;
                }
                // case 3 - now encountered usable char, extract it for comparison with T
                else
                    break;
            }

            // look for first usable character in T
            while (j >= 0) {
                // case 1 - if # char - incr count of bckspace (skipS), and decr i
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                }
                // case 2 - if not a # char, and # has been encountered earlier,
                // then ignore as many bckspace chars as has been accumulated in skipS so far, and decr it
                else if (skipT > 0) {
                    skipT--;
                    j--;
                }
                // case 3 - now encountered usable char, extract it for comparison with S
                else
                    break;
            }

            // if chars exists in both i and j -> compare them, return false if not equal
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;

            // if one char exists in S or T while no chars left in other, return false
            if ((i >= 0 && j < 0) || (i < 0 && j >= 0))
                return false;

            i--;
            j--;

        }
        // outside while - return true
        return true;

    }
}
