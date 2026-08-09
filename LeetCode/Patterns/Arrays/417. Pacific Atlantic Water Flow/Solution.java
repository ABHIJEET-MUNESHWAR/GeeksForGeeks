//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    // Directions for moving up, down, left, right
    private final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];

        // Start DFS from pacificVisited border (top row and left column)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacificVisited, i, 0, Integer.MIN_VALUE);
            dfs(heights, atlanticVisited, i, n - 1, Integer.MIN_VALUE);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacificVisited, 0, j, Integer.MIN_VALUE);
            dfs(heights, atlanticVisited, m - 1, j, Integer.MIN_VALUE);
        }

        // Collect cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;

        // Out of bounds or already visited or not valid move
        if (i < 0 || i >= m || j < 0 || j >= n
                || visited[i][j] || heights[i][j] < prevHeight) {
            return;
        }

        visited[i][j] = true;

        // Explore 4 directions
        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            dfs(heights, visited, ni, nj, heights[i][j]);
        }
    }
}