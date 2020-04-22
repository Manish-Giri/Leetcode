package leftmostcolumnwithatleastaone;

import java.util.List;

/**
 * (This problem is an interactive problem.)
 * <p>
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
 * <p>
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 * <p>
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 * <p>
 * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [m, n], which means the matrix is m * n.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * <p>
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 * <p>
 * <p>
 * Example 2:
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 * <p>
 * <p>
 * Example 3:
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 * <p>
 * <p>
 * Example 4:
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * mat[i][j] is either 0 or 1.
 * mat[i] is sorted in a non-decreasing way.
 */

/* This is the BinaryMatrix's API interface.
 * You should not implement it, or speculate about its implementation
 */

interface BinaryMatrix {
    int get(int x, int y);

    List<Integer> dimensions();
}

class Solution {

    /*
     Runtime: 0 ms
     Memory Usage: 39.9 MB
    */
    // TODO: Explore other solutions
    int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);

        // Set pointers to the top-right corner.
        int currentRow = 0;
        int currentCol = cols - 1;

        // Repeat the search until it goes off the grid.
        while (currentRow < rows && currentCol >= 0) {
            if (binaryMatrix.get(currentRow, currentCol) == 0) {
                currentRow++;
            } else {
                currentCol--;
            }
        }

        // If we never left the last column, this is because it was all 0's.
        return (currentCol == cols - 1) ? -1 : currentCol + 1;
    }
}
