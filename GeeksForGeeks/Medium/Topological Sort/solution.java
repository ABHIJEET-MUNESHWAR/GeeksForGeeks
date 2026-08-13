class Solution {
	public void dfs(Map<Integer, List<Integer>> adj, int u, boolean[] isVisited, Stack<Integer> stack) {
		isVisited[u] = true;
		for (int v: adj.getOrDefault(u, new ArrayList<>())) {
			if (!isVisited[v]) {
				dfs(adj, v, isVisited, stack);
			}
		}
		stack.push(u);
	}
	public ArrayList<Integer> topoSort(int V, int[][] edges) {
		// code here
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> topologicalSort = new ArrayList<>();
		boolean[] isVisited = new boolean[V];
		Map<Integer, List<Integer>> adj = new HashMap<>();
		for (int[] edge: edges) {
			adj.computeIfAbsent(edge[0], key->new ArrayList<>()).add(edge[1]);
		}
		for (int i = 0; i<V; i++) {
			if (!isVisited[i]) {
				dfs(adj, i, isVisited, stack);
			}
		}
		while (!stack.isEmpty()) {
			topologicalSort.add(stack.pop());
		}
		return topologicalSort;
	}
}
