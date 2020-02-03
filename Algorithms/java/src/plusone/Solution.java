package plusone;

import java.util.LinkedList;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0, sum = 0;
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                sum = digits[i] + 1;
            } else {
                sum = carry + digits[i];
            }

            if (sum > 9) {
                sum = 0;
                carry = 1;
            } else {
                carry = 0;
            }

            nums.addFirst(sum);
        }
        if (carry != 0)
            nums.addFirst(carry);
        return nums.stream().mapToInt(i -> i).toArray();
    }
}

/*
Runtime: 3 ms, faster than 11.38% of Java online submissions for Plus One.
Memory Usage: 38.4 MB, less than 5.64% of Java online submissions for Plus One.
 */