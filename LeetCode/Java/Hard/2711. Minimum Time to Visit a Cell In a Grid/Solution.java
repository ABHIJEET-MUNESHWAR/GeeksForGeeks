class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        boolean[][] isVisited = new boolean[m][n];
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[] { grid[0][0], 0, 0 });
        result[0][0] = 0;
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int time = current[0];
            int row = current[1];
            int col = current[2];
            if (row == m - 1 && col == n - 1) {
                return result[m - 1][n - 1];
            }
            if (isVisited[row][col]) {
                continue;
            }
            isVisited[row][col] = true;
            for (int[] direction : directions) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || r >= m || c < 0 || c >= n) {
                    continue;
                }
                int nextTime = 0;
                if (grid[r][c] <= time + 1) {
                    nextTime = time + 1;
                } else if ((grid[r][c] - time) % 2 == 0) {
                    nextTime = grid[r][c] + 1;
                } else {
                    nextTime = grid[r][c];
                }
                if (result[r][c] > nextTime) {
                    result[r][c] = nextTime;
                    minHeap.offer(new int[] { nextTime, r, c });
                }
            }
        }
        return -1;
    }
}