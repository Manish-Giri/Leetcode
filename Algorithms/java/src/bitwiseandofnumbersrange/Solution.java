package bitwiseandofnumbersrange;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * <p>
 * Example 1:
 * <p>
 * Input: [5,7]
 * Output: 4
 * Example 2:
 * <p>
 * Input: [0,1]
 * Output: 0
 */

class Solution {

    /**
     * Approach One - brute force
     * Time - O(n), touches every number in the range
     * TLE, exceeded limit
     */
    int rangeBitwiseAnd_ApproachOne(int m, int n) {
        int res = m;
        for (int i = m + 1; i <= n; i++)
            res &= i;
        return res;
    }

    /**
     * Approach Two - bitwise shift
     * Time - O(1) because number of ops in loop is bounded by number of bits in number m and n (constant)
     * Space - O(1)
     * Runtime: 4 ms, faster than 100.00% of Java online submissions for Bitwise AND of Numbers Range.
     * Memory Usage: 38.7 MB, less than 10.00% of Java online submissions for Bitwise AND of Numbers Range.
     */
    int rangeBitwiseAnd_ApproachTwo(int m, int n) {
        int shiftCount = 0;
        while (m != n) {
            // shift both m and n right by 1 bit
            m >>= 1;
            n >>= 1;
            shiftCount++;
        }
        // number of nits shifted left
        return m << shiftCount;
    }
}
