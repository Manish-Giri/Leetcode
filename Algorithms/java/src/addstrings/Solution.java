package addstrings;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

class Solution {

    /**
     * Approach - Trick - any number represented as a char - '0' gives the difference in int
     * ex - '3' - '0' = 3, '9' - '0' = 9
     * <p>
     * Iterate over both strings in reverse (to account for carry) and append the sum to a stringbuilder
     * reverse the sb when done
     * <p>
     * Time: O(m+n), where m and n are length of the 2 numbers, Space: O(1)
     * <p>
     * Runtime: 3 ms, faster than 50.23% of Java online submissions for Add Strings..
     * Memory Usage: 39.9 MB, less than 6.25% of Java online submissions for Add Strings.
     */
    String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int num1Pos = num1.length() - 1, num2Pos = num2.length() - 1, carry = 0, sum = 0;
        int n1 = 0, n2 = 0;

        // while number remaining in each string
        while (num1Pos >= 0 || num2Pos >= 0) {
            if (num1Pos >= 0)
                n1 = num1.charAt(num1Pos) - '0';
            if (num2Pos >= 0)
                n2 = num2.charAt(num2Pos) - '0';
            sum = carry + n1 + n2;

            if (sum > 9) {
                // sum -= 10 is required to get the last digit correctly
                // ex, for 9 + 9, carry = 1, sum = 18-10 = 8 (last digit)
                carry = 1;
                sum -= 10;
            } else
                carry = 0;

            sb.append(sum);

            // this is necessary to clear any left over numbers if both nums are of different digits
            // ex, "9" and "99"
            n1 = 0;
            n2 = 0;

            num1Pos--;
            num2Pos--;
        }
        // to account for left over carry
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
