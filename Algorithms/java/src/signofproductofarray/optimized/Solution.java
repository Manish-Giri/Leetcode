package signofproductofarray.optimized;

class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sign of the Product of an Array.
     * Memory Usage: 38.8 MB, less than 49.87% of Java online submissions for Sign of the Product of an Array.
     *
     * approach -> if encounter a zero, return zero immediate, else keep track of number of negatives in array
     * -> if number of negatives is even, product is +ve, else -ve, return 1/-1 accordingly
     */
    int arraySignOne(int[] nums) {
        int numNegs = 0;
        for (int n : nums) {
            if (n == 0)
                return 0;
            if (n < 0)
                numNegs++;
        }
        return numNegs % 2 == 0 ? 1 : -1;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sign of the Product of an Array.
     * Memory Usage: 38.2 MB, less than 97.89% of Java online submissions for Sign of the Product of an Array.
     *
     * approach -> Optimizing above approach, no need to use space to keep track of number of -ves
     * -> start with a positive sign (+1), and each time a -ve number is encountered, flip the sign to -ve of curr sign
     * -> return sign at the end
     * ex: [2, -10, 22, -4, -45, 12] -> 1, -1, -1, +1, -1, -1 -> return -1
     */

    int arraySign(int[] nums) {
        int sign = 1;
        for(int n: nums) {
            if(n == 0) return 0;
            if(n < 0) sign = -sign;
        }
        return sign;
    }

}
