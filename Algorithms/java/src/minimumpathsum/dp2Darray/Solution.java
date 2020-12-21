package minimumpathsum.dp2Darray;

/**
 * Complexities
 * Time - O(mn) - traverse entire matrix once
 * Space - O(mn) - another matrix of same size is used
 */
 class Solution {

     /**
      * DP solution using a separate 2D array
      * Runtime: 2 ms, faster than 81.89% of Java online submissions for Minimum Path Sum.
      * Memory Usage: 42 MB, less than 32.38% of Java online submissions for Minimum Path Sum.
      *
      * @param grid
      * @return
      */
     int minPathSum(int[][] grid) {
        // separate 2D array
        int[][] dp = new int[grid.length][grid[0].length];

        for(int i = grid.length-1; i >= 0; i--) {
            for(int j = grid[i].length-1; j >= 0; j--) {
                // bottom row
                if(i == grid.length-1) {
                    // bottom right cell
                    if(j == grid[i].length-1) {
                        dp[i][j] = grid[i][j];
                    }
                    // bottom row,except right cell
                    else {
                        dp[i][j] = grid[i][j] + dp[i][j+1];
                    }
                }
                // other rows
                else {
                    // rightmost column
                    if(j == grid[i].length-1) {
                        dp[i][j] = grid[i][j] + dp[i+1][j];
                    }
                    else {
                        // all other columns
                        dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                    }
                }

            }
        } // end outer for

        return dp[0][0];
    }
}

/*

LC solution

     public int minPathSum(int[][] grid) {
         int[][] dp = new int[grid.length][grid[0].length];
         for (int i = grid.length - 1; i >= 0; i--) {
             for (int j = grid[0].length - 1; j >= 0; j--) {
                 // bottom row, excluding bottom right cell
                 if(i == grid.length - 1 && j != grid[0].length - 1)
                     dp[i][j] = grid[i][j] +  dp[i][j + 1];
                 // rightmost column, except bottom right cell
                 else if(j == grid[0].length - 1 && i != grid.length - 1)
                     dp[i][j] = grid[i][j] + dp[i + 1][j];
                 // all other cells, except bottom right cell
                 else if(j != grid[0].length - 1 && i != grid.length - 1)
                     dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                 else
                    // bottom right cell
                     dp[i][j] = grid[i][j];
             }
         }
         return dp[0][0];
     }

 */