package com.geeksforgeeks.datastructures.graph.nooftrees;

import java.util.LinkedList;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    21/07/18,
 * Time:    4:41 PM
 */
public class Graph {

  private int vertices;
  private LinkedList<Integer>[] adjList;

  Graph(int v) {
    this.vertices = v;
    this.adjList = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  public void addEdge(int u, int v) {
    adjList[u].add(v);
  }

  public static void main(String[] args) {
    Graph graph = new Graph(5);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(3, 4);
    System.out.println("The number of trees is: " + graph.dfs());
  }

  private int dfs() {
    boolean[] visited = new boolean[vertices];
    int noOfTrees = 0;
    for (int i = 0; i < vertices; i++) {
      if (!visited[i]) {
        dfsUtil(i, visited);
        noOfTrees++;
      }
    }
    return noOfTrees;
  }

  private void dfsUtil(int source, boolean[] visited) {
    for (Integer i : adjList[source]) {
      if (!visited[i]) {
        visited[i] = true;
        dfsUtil(i, visited);
      }
    }
  }
}
