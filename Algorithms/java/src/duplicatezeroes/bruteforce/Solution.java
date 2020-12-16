package duplicatezeroes.bruteforce;

import java.util.ArrayList;
import java.util.List;

class Solution {

    // time - O(n), iterate array twice
    // space - O(n)

    /**
     * Runtime: 2 ms, faster than 60.56% of Java online submissions for Duplicate Zeros.
     * Memory Usage: 40.2 MB, less than 9.23% of Java online submissions for Duplicate Zeros.
     * @param arr
     */
    void duplicateZeros(int[] arr) {

        // approach 1 - save numbers from arr in ArrayList, duplicating zeroes
        List<Integer> nums = new ArrayList<>();
        int size = arr.length;
        for (int n : arr) {
            if (n == 0) {
                nums.add(0);
                nums.add(0);
            } else {
                nums.add(n);
            }
        }

        // overwrite arr from start, truncating elements beyond arr.length
        for (int i = 0; i < size; i++) {
            arr[i] = nums.get(i);
        }

    }
}
