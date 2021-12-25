package signofproductofarray.optimized;

class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sign of the Product of an Array.
     * Memory Usage: 38.8 MB, less than 49.87% of Java online submissions for Sign of the Product of an Array.
     */
    int arraySign(int[] nums) {
        int numNegs = 0;
        for (int n : nums) {
            if (n == 0)
                return 0;
            if (n < 0)
                numNegs++;
        }
        return numNegs % 2 == 0 ? 1 : -1;
    }
}
