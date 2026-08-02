class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, areaOfIsland(grid, i, j, m, n));
                }
            }
        }
        return maxArea;
    }

    private int areaOfIsland(int[][] grid, int row, int col, int m, int n) {
        if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
            grid[row][col] = 0;
            return 1 + areaOfIsland(grid, row + 1, col, m, n)
                    + areaOfIsland(grid, row - 1, col, m, n)
                    + areaOfIsland(grid, row, col + 1, m, n)
                    + areaOfIsland(grid, row, col - 1, m, n);
        }
        return 0;
    }
}