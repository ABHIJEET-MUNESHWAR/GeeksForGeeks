class Solution {
    int goodPaths = 0;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int n = vals.length;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }
        for (int key : adj.keySet()) {
            boolean[] isVisited = new boolean[n];
            isGoodPathDFS(adj, vals, isVisited, key, key);
        }
        return goodPaths / 2 + n;
    }

    public void isGoodPathDFS(Map<Integer, List<Integer>> adj, int[] vals, boolean[] isVisited, int source,
            int current) {
        if (source != current && vals[source] == vals[current]) {
            goodPaths++;
        }
        isVisited[current] = true;
        for (int v : adj.getOrDefault(current, Collections.emptyList())) {
            if (!isVisited[v] && vals[source] >= vals[v]) {
                isGoodPathDFS(adj, vals, isVisited, source, v);
            }
        }
    }
}