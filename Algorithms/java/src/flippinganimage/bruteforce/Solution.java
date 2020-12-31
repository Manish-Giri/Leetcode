package flippinganimage.bruteforce;

import java.util.Arrays;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 * <p>
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */

class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flipping an Image.
     * Memory Usage: 39.3 MB, less than 65.05% of Java online submissions for Flipping an Image.
     *
     * @param A
     * @return
     */
    int[][] flipAndInvertImage(int[][] A) {
        int[][] copy = new int[A.length][];
        // reverse every row
        for (int i = 0; i < A.length; i++) {
            int colIdx = 0;
            // deep copy
            copy[i] = Arrays.copyOf(A[i], A[i].length);
            for (int j = A[i].length - 1; j >= 0; j--) {
                copy[i][colIdx++] = A[i][j];
            }
        }

        // inverse each cell
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                copy[i][j] = 1 - copy[i][j];
            }
        }

        return copy;

    }
}
