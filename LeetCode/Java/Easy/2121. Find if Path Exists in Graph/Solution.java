class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

    boolean[] visited = new boolean[n];
    HashSet<Integer>[] graph = new HashSet[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new HashSet<>();
    }
    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }
    if (graph[source].contains(destination)) {
      return true;
    }
    Queue<Integer> queue = new PriorityQueue<>();
    visited[source] = true;
    queue.add(source);
    int current;
    while (!queue.isEmpty()) {
      current = queue.poll();
      if (current == destination) {
        return true;
      }
      for (int neighbour : graph[current]) {
        if (!visited[neighbour]) {
          visited[neighbour] = true;
          queue.add(neighbour);
        }
      }
    }
    return false;        
    }
}