package com.geeksforgeeks.datastructures.graph.dfs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 25/02/17
 * Time: 3:35 PM
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 */
public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adj;

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

    private void DFS(int s) {
        boolean[] visited = new boolean[vertices];
        DFSUtil(s, visited);
    }

    private void DFSUtil(int s, boolean[] visited) {
        visited[s] = true;
        System.out.println(s);
        Iterator<Integer> i = adj[s].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");

        g.DFS(2);
    }
}
