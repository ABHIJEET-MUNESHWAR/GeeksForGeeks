class Solution {
	public boolean isCycleDFS(Map<Integer, List<Integer>> adj, int V, boolean[] isVisited, boolean[] inRecursion, int u) {
		isVisited[u] = true;
		inRecursion[u] = true;
		for (int v: adj.getOrDefault(u, new ArrayList<>())) {
			if (!isVisited[v] && isCycleDFS(adj, V, isVisited, inRecursion, v)) {
				return true;
			} else if (inRecursion[v]) {
				return true;
			}
		}
		inRecursion[u] = false;
		return false;
	}
	public boolean isCyclic(int V, int[][] edges) {
		// code here
		boolean[] isVisited = new boolean[V];
		boolean[] inRecursion = new boolean[V];
		Map<Integer, List<Integer>> adj = new HashMap<>();
		for (int[] edge: edges) {
			int u = edge[0];
			int v = edge[1];
			adj.computeIfAbsent(u, key->new ArrayList<>()).add(v);
		}
		for (int i = 0; i<V; i++) {
			if (!isVisited[i] && isCycleDFS(adj, V, isVisited, inRecursion, i)) {
				return true;
			}
		}
		return false;
	}
}
