package poweroftwo.bruteforce;

/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 */

class Solution {
    /**
     * Runtime: 2 ms, faster than 62.44% of Java online submissions for Power of Two.
     * Memory Usage: 42.2 MB, less than 5.29% of Java online submissions for Power of Two.
     */
    boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 31; i++) {
            if ((int) Math.pow(2, i) == n) return true;
        }
        return false;
    }
}
