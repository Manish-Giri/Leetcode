package BINARYSEARCH.intersectionofhreesortedarrays.attempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * Output: [1,5]
 * Explanation: Only 1 and 5 appeared in the three arrays.
 * Example 2:
 * <p>
 * Input: arr1 = [197,418,523,876,1356], arr2 = [501,880,1593,1710,1870], arr3 = [521,682,1337,1395,1764]
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr1.length, arr2.length, arr3.length <= 1000
 * 1 <= arr1[i], arr2[i], arr3[i] <= 2000
 */
class Solution {

    /**
     * Runtime
     * 2 ms
     * Beats
     * 82.98%
     * Memory
     * 43.4 MB
     * Beats
     * 16.11%
     *
     * @param arr1
     * @param arr2
     * @param arr3
     * @return
     */
    List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> al = new ArrayList<>();
        for (int i : arr1) {
            if ((Arrays.binarySearch(arr2, i) > -1) && (Arrays.binarySearch(arr3, i) > -1))
                al.add(i);
        }
        return al;
    }
}
