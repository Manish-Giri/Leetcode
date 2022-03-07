package reverseinteger.solution.math;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
class Solution {

    /**
     * Runtime: 1 ms, faster than 99.17% of Java online submissions for Reverse Integer.
     * Memory Usage: 41.8 MB, less than 17.34% of Java online submissions for Reverse Integer.
     *
     */
    int reverse(int x) {
        int ans = 0;
        int num = x;
        while (num != 0) {
            // extract last digit
            int digit = num % 10;
            // reduce num
            num /= 10;
            // keep constructing reversed number
            // NOTE: multiply by 10 can cause number to go out of int range
            // condition: if (ans * 10) > MAX_VALUE OR if(ans > MAX_VALUE / 10)
            if ((ans > Integer.MAX_VALUE / 10) || (ans < Integer.MIN_VALUE / 10))
                return 0;
            // otherwise, continue multiplying
            ans = (ans * 10) + digit;
        }
        return ans;
    }
}

