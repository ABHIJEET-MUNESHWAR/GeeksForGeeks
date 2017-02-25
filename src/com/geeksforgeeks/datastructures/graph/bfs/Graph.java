package com.geeksforgeeks.datastructures.graph.bfs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 25/02/17
 * Time: 3:19 PM
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 */
public class Graph {
    private int vertices;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
    }

    private void BFS(int s) {
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.println(s);
            Iterator<Integer> i = adj[s].iterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        graph.BFS(2);
    }
}
