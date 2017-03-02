package com.geeksforgeeks.datastructures.graph.shortestpathdag;

import sun.security.provider.certpath.AdjacencyList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 28/02/17
 * Time: 7:06 AM
 */
public class ShortestPath {
    static final int INF = Integer.MAX_VALUE;

    class AdjListNode {
        private int v;
        private int weight;

        AdjListNode(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public int getV() {
            return this.v;
        }

        public int getWeight() {
            return this.weight;
        }
    }

    class Graph {
        private int vertices;
        private LinkedList<AdjListNode>[] adj;

        Graph(int v) {
            vertices = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<AdjListNode>();
            }
        }

        private void addEdge(int u, int v, int weight) {
            AdjListNode node = new AdjListNode(v, weight);
            adj[u].add(node);
        }

        private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
            visited[v] = true;
            Iterator<AdjListNode> itr = adj[v].iterator();
            while (itr.hasNext()) {
                AdjListNode node = itr.next();
                if (!visited[node.getV()]) {
                    topologicalSortUtil(node.getV(), visited, stack);
                }
            }
            stack.push(v);
        }

        public void shortestPath(int s) {
            Stack<Integer> stack = new Stack<>();
            int[] dist = new int[vertices];
            boolean[] visited = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }
            for (int i = 0; i < vertices; i++) {
                dist[i] = INF;
            }
            dist[s] = 0;
            while (!stack.isEmpty()) {
                int u = stack.pop();
                if (dist[u] != INF) {
                    Iterator<AdjListNode> itr = adj[u].iterator();
                    while (itr.hasNext()) {
                        AdjListNode node = itr.next();
                        if (dist[node.getV()] > (dist[u] + node.getWeight())) {
                            dist[node.getV()] = dist[u] + node.getWeight();
                        }
                    }
                }
            }
            for (int i = 0; i < vertices; i++) {
                if (dist[i] == INF) {
                    System.out.println("INF");
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }

    private Graph newGraph(int v) {
        return new Graph(v);
    }

    public static void main(String[] args) {
        ShortestPath t = new ShortestPath();
        Graph g = t.newGraph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int s = 1;
        System.out.println("Following are shortest distances " +
                "from source " + s);
        g.shortestPath(s);
    }
}
