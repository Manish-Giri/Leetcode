package numberofislands;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */

class Solution {
    int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int numRows = grid.length;
        int numCols = grid[0].length;
        int numIslands = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                // if current node is a '1', it is a root node that triggers a DFS
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    // recursive DFS func
    private void dfs(char[][] grid, int row, int col) {
        // base case - when array index is invalid OR cell is '0'
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        } else {
            // mark cell as '0' and check horizontal and vertical adjacent cells
            grid[row][col] = '0';
            dfs(grid, row - 1, col);
            dfs(grid, row, col - 1);
            dfs(grid, row, col + 1);
            dfs(grid, row + 1, col);
        }
    }
}

/*
Success
Details 
Runtime: 1 ms, faster than 99.99% of Java online submissions for Number of Islands.
Memory Usage: 42.1 MB, less than 35.82% of Java online submissions for Number of Islands.
 */