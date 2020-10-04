package kdiffpairsinarray;

import java.util.HashMap;
import java.util.Objects;

/**
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 *
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 *
 * 0 <= i, j < nums.length
 * i != j
 * a <= b
 * b - a == k
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 *
 * Input: nums = [1,3,1,5,4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Example 4:
 *
 * Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
 * Output: 2
 * Example 5:
 *
 * Input: nums = [-1,-2,-3], k = 1
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 */

class Solution {

    /**
     * Runtime: 491 ms, faster than 7.50% of Java online submissions for K-diff Pairs in an Array.
     * Memory Usage: 39.2 MB, less than 95.75% of Java online submissions for K-diff Pairs in an Array.
     *
     * Time - O(n^2) | Space - O(n)
     * @param nums
     * @param k
     * @return
     */
    int findPairs(int[] nums, int k) {
        HashMap<Pair, Integer> diffs = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) == k) {

                    Pair p = new Pair(nums[i], nums[j]);
                    if (!diffs.containsKey(p)) {
                        diffs.put(p, k);
                    }

                }
            }
        }
        return diffs.size();
    }
}

class Pair {
    int a;
    int b;

    Pair(int x, int y) {
        a = x;
        b = y;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        Pair p = (Pair) other;
        // return ((this.a == p.a && this.b == p.b) || (this.a == p.b && this.b == p.a));
        //(3,0) -> (3,0)
        if (this.a == p.a && this.b == p.b) return true;
        // (3,0) -> (0,3)
        return this.a == p.b && this.b == p.a;

    }

    // to make sure a Pair with same numbers map to the same hashcode
    // ex: <3,0> and <0,3>
    @Override
    public int hashCode() {
        return Objects.hashCode(a + b);
    }

    @Override
    public String toString() {
        return "<a=" + a + " b=" + b + ">";
    }
}

