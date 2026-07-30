class Solution {
    class DSU {
        int[] parent;
        int[] rank;
        int components;

        public DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            components = n;
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
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
            if (rank[parentOfI] > rank[parentOfJ]) {
                parent[parentOfJ] = parentOfI;
            } else if (rank[parentOfI] < rank[parentOfJ]) {
                parent[parentOfI] = parentOfJ;
            } else {
                parent[parentOfI] = parentOfJ;
                rank[parentOfJ]++;
            }
            this.components--;
        }

        public boolean isSingleComponent() {
            return components == 1;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU aliceDSU = new DSU(n);
        DSU bobDSU = new DSU(n);
        int addedEdges = 0;
        Arrays.sort(edges, (a, b) -> (b[0] - a[0]));
        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];
            switch (type) {
                case 3:
                    boolean isAdded = false;
                    if (aliceDSU.find(u) != aliceDSU.find(v)) {
                        aliceDSU.union(u, v);
                        isAdded = true;
                    }
                    if (bobDSU.find(u) != bobDSU.find(v)) {
                        bobDSU.union(u, v);
                        isAdded = true;
                    }
                    if (isAdded) {
                        addedEdges++;
                    }
                    break;
                case 2:
                    if (bobDSU.find(u) != bobDSU.find(v)) {
                        bobDSU.union(u, v);
                        addedEdges++;
                    }
                    break;
                case 1:
                    if (aliceDSU.find(u) != aliceDSU.find(v)) {
                        aliceDSU.union(u, v);
                        addedEdges++;
                    }
                    break;
            }
        }
        if (bobDSU.isSingleComponent() && aliceDSU.isSingleComponent()) {
            return edges.length - addedEdges;
        }
        return -1;
    }
}