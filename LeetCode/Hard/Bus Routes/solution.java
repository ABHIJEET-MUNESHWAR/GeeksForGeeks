class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> busStopToRouteIndexMap = new HashMap<>();

        int noOfRoutes = routes.length;
        for (int i = 0; i < noOfRoutes; i++) {
            int[] busStops = routes[i];
            int busStopsLength = busStops.length;
            for (int j = 0; j < busStopsLength; j++) {
                busStopToRouteIndexMap.computeIfAbsent(busStops[j], key -> new ArrayList<>()).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[501];
        for (int busStop : busStopToRouteIndexMap.getOrDefault(source, new ArrayList<>())) {
            queue.offer(busStop);
            visited[busStop] = true;
        }
        int hops = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            while (queueSize-- > 0) {
                int route = queue.poll();
                for (int busStop : routes[route]) {
                    if (busStop == target) {
                        return hops;
                    }
                    for (int nextBusStop : busStopToRouteIndexMap.getOrDefault(busStop, Collections.emptyList())) {
                        if (!visited[nextBusStop]) {
                            queue.offer(nextBusStop);
                            visited[nextBusStop] = true;
                        }
                    }
                }
            }
            hops++;
        }
        return -1;
    }
}