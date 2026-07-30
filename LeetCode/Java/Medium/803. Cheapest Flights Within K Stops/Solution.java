class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst) {
            return 0;
        }
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            adj.computeIfAbsent(from, key -> new ArrayList<>()).add(new int[] { to, price });
        }
        return findCheapestPrice(n, adj, src, dst, k);
    }

    public int findCheapestPrice(int n, Map<Integer, List<int[]>> adj, int src, int dst, int k) {
        int[] minPriceDistance = new int[n];
        Arrays.fill(minPriceDistance, Integer.MAX_VALUE);
        minPriceDistance[src] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, src });
        k++;
        while (!queue.isEmpty() && k > 0) {
            int queueSize = queue.size();
            while (queueSize-- > 0) {
                int[] current = queue.poll();
                int currentPrice = current[0];
                int currentNode = current[1];
                List<int[]> neighbours = adj.getOrDefault(currentNode, Collections.emptyList());
                for (int[] neighbour : neighbours) {
                    int dstNode = neighbour[0];
                    int dstPrice = neighbour[1];
                    if (minPriceDistance[dstNode] > (currentPrice + dstPrice)) {
                        minPriceDistance[dstNode] = (currentPrice + dstPrice);
                        queue.add(new int[] { currentPrice + dstPrice, dstNode });
                    }
                }
            }
            k--;
        }
        return minPriceDistance[dst] == Integer.MAX_VALUE ? -1 : minPriceDistance[dst];
    }
}