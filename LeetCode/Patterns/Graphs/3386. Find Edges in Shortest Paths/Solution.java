class Solution {
    public boolean[] findAnswer(int n, int[][] edges) {
        int totalEdges = edges.length;
        Map<Integer, List<int[]>> adjacencyMap = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adjacencyMap.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[] { v, weight });
            adjacencyMap.computeIfAbsent(v, key -> new ArrayList<>()).add(new int[] { u, weight });
        }
        int[] sourceMinDistance = dijkstra(n, adjacencyMap, 0);
        int[] destinationMinDistance = dijkstra(n, adjacencyMap, n - 1);
        boolean[] answer = new boolean[totalEdges];
        for (int i = 0; i < totalEdges; i++) {
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (((sourceMinDistance[u] + weight + destinationMinDistance[v]) == sourceMinDistance[n - 1])
                    || ((sourceMinDistance[v] + weight + destinationMinDistance[u]) == sourceMinDistance[n - 1])) {
                answer[i] = true;
            }
        }
        return answer;
    }

    public int[] dijkstra(int n, Map<Integer, List<int[]>> adjacencyMap, int source) {
        int[] minDistance = new int[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[source] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[] { 0, source });
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentWeight = current[0];
            int currentNode = current[1];
            if (currentWeight > minDistance[currentNode]) {
                continue;
            }
            for (int[] v : adjacencyMap.getOrDefault(currentNode, Collections.emptyList())) {
                int nextNode = v[0];
                int nextWeight = v[1];
                if (minDistance[nextNode] > (minDistance[currentNode] + nextWeight)) {
                    minDistance[nextNode] = (minDistance[currentNode] + nextWeight);
                    minHeap.offer(new int[] { minDistance[nextNode], nextNode });
                }
            }
        }
        return minDistance;
    }
}