class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 0;
        }
    }

    public int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public void union(int i, int j) {
        int parentOfI = find(i);
        int parentOfJ = find(j);
        if (parentOfI == parentOfJ) {
            return;
        }
        if (size[parentOfI] > size[parentOfJ]) {
            parent[parentOfJ] = parentOfI;
            size[parentOfI] += size[parentOfJ];
        } else {
            parent[parentOfI] = parentOfJ;
            size[parentOfJ] += size[parentOfI];
        }
    }

    public void setSize(int i, int fishCount) {
        size[i] = fishCount;
    }

    public int getMaxFishCount() {
        int maxFishCount = 0;
        for (int fishCount : size) {
            maxFishCount = Math.max(maxFishCount, fishCount);
        }
        return maxFishCount;
    }
}

class Solution {
    public int findMaxFish(int[][] grid) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int m = grid.length;
        int n = grid[0].length;
        DSU fisherManDSU = new DSU(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    int index = i * n + j;
                    fisherManDSU.setSize(index, grid[i][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    int index = i * n + j;
                    for (int[] direction : directions) {
                        int i_ = i + direction[0];
                        int j_ = j + direction[1];
                        if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n && grid[i_][j_] > 0) {
                            int index_ = i_ * n + j_;
                            fisherManDSU.union(index, index_);
                        }
                    }
                }
            }
        }
        return fisherManDSU.getMaxFishCount();
    }
}