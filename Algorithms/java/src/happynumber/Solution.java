package happynumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 */

class Solution {
    public boolean isHappy(int n) {
        List<Integer> sums = new ArrayList<>();
        while(true) {
            if (n == 1)
                return true;
            else {
                int tsum = 0;
                while(n > 0) {
                    int curr_digit = n % 10;
                    int curr_square = curr_digit * curr_digit;
                    tsum += curr_square;
                    n /= 10;
                }
                if(sums.contains(tsum)) {
                    return false;
                }
                sums.add(tsum);
                n = tsum;
            }
        }
    }
}

/*
Runtime: 1 ms, faster than 97.86% of Java online submissions for Happy Number.
Memory Usage: 36.4 MB, less than 6.06% of Java online submissions for Happy Number.

*/

