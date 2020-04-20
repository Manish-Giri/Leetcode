package minimumpathsum;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Solution {
    int minPathSum_ApproachOne(int[][] grid) {
        return calc(grid, 0,0);
    }

    /**
     * Approach 1 - Brute Force, for each cell, check both forward & downward path
     * TLE
     */

    private int calc(int[][] grid, int i, int j) {
        // if destination - return cell value
        if(i == grid.length -1 && j == grid[i].length - 1) return grid[i][j];

        // if i or j exceeds
        if(i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;

        // else return sum of cell + min of right path & down path
        return grid[i][j] + Math.min(calc(grid, i+1, j), calc(grid, i, j+1));
    }

    /**
     * Approach 2 - DP, with another matrix for storing min path sums
     * Runtime: 3 ms, faster than 24.25% of Java online submissions for Minimum Path Sum.
     * Memory Usage: 42.1 MB, less than 85.13% of Java online submissions for Minimum Path Sum.
     *
     * Time - O(mn), Space - O(mn)
     */
    // TODO: Study other solutions
    int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }
}
