class Solution {
    int[][] directions = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pacificAtlanticDFS(heights, pacificVisited, i, 0, Integer.MIN_VALUE);
            pacificAtlanticDFS(heights, atlanticVisited, i, n - 1, Integer.MIN_VALUE);
        }
        for (int j = 0; j < n; j++) {
            pacificAtlanticDFS(heights, pacificVisited, 0, j, Integer.MIN_VALUE);
            pacificAtlanticDFS(heights, atlanticVisited, m - 1, j, Integer.MIN_VALUE);
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    resultList.add(Arrays.asList(i, j));
                }
            }
        }
        return resultList;
    }

    public void pacificAtlanticDFS(int[][] heights, boolean[][] oceanVisited, int i, int j, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || oceanVisited[i][j] || prevHeight > heights[i][j]) {
            return;
        }
        oceanVisited[i][j] = true;
        for (int[] direction : directions) {
            int i_ = i + direction[0];
            int j_ = j + direction[1];
            pacificAtlanticDFS(heights, oceanVisited, i_, j_, heights[i][j]);
        }
    }
}