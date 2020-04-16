package findnumberswithevennumofdigits;

/**
 * Given an array nums of integers, return how many of them contain an even number of digits.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 * Example 2:
 * <p>
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 */
class Solution {

    /*
    Runtime: 1 ms, faster than 92.37% of Java online submissions for Find Numbers with Even Number of Digits.
    Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Find Numbers with Even Number of Digits.
    */
    int findNumbers(int[] nums) {
        int evenDigits = 0;
        for (int n : nums) {
            if (String.valueOf(n).length() % 2 == 0)
                evenDigits++;
        }
        return evenDigits;
    }
}
