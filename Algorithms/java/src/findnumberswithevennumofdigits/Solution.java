package findnumberswithevennumofdigits;

import java.util.Arrays;

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


    /**
     * Approach - Check length of string representation of number
     * <p>
     * Runtime: 1 ms, faster than 92.37% of Java online submissions for Find Numbers with Even Number of Digits.
     * Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Find Numbers with Even Number of Digits.
     */
    int findNumbers_ApproachOne(int[] nums) {
        int evenDigits = 0;
        for (int n : nums) {
            if (String.valueOf(n).length() % 2 == 0)
                evenDigits++;
        }
        return evenDigits;
    }


    /**
     * Approach - Using streams, Check length of string representation of number
     * <p>
     * Runtime: 3 ms, faster than 11.97% of Java online submissions for Find Numbers with Even Number of Digits.
     * Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Find Numbers with Even Number of Digits.
     */
    int findNumbers_ApproachTwo(int[] nums) {
        return (int) Arrays.stream(nums).filter(arr -> String.valueOf(arr).length() % 2 == 0).count();
    }

    /**
     * Approach - Count number of digits of each number, select even digit numbers
     * <p>
     * Runtime: 1 ms, faster than 92.37%  of Java online submissions for Find Numbers with Even Number of Digits.
     * Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Find Numbers with Even Number of Digits.
     */
    int findNumbers_ApproachThree(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            if (countDigits(n) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    private int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}
