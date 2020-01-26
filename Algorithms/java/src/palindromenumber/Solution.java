package palindromenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 */

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        List<Integer> rev = new ArrayList<>();
        int num = x;
        while (num > 0) {
            int last = num % 10;
            rev.add(last);
            num /= 10;
        }
        for (int i = 0, j = rev.size() - 1; i <= j; i++, j--) {
            if (rev.get(i) != rev.get(j)) {
                return false;
            }
        }
        return true;
    }
}

/*
Runtime: 8 ms, faster than 43.80% of Java online submissions for Palindrome Number.
Memory Usage: 40.7 MB, less than 5.02% of Java online submissions for Palindrome Number.
 */