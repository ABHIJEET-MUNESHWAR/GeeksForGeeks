package com.geeksforgeeks.datastructures.graph.topologicalsort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 27/02/17
 * Time: 9:20 PM
 */
public class TopologicalSort {
    private int vertices;
    private LinkedList<Integer>[] adj;

    TopologicalSort(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        Iterator<Integer> itr = adj[v].listIterator();
        while (itr.hasNext()) {
            int i = itr.next();
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        stack.push(v);
    }

    private void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        System.out.println("Following is a Topological " +
                "sort of the given graph");
        graph.topologicalSort();
    }
}
