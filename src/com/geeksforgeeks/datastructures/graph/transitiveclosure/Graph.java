package com.geeksforgeeks.datastructures.graph.transitiveclosure;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    01/07/18,
 * Time:    2:20 PM
 * https://www.geeksforgeeks.org/transitive-closure-of-a-graph-using-dfs/
 */
public class Graph {

  private int vertices;
  private LinkedList<Integer>[] adjList;
  private int[][] tc;

  Graph(int v) {
    this.vertices = v;
    adjList = new LinkedList[v];
    for (int i = 0; i < vertices; i++) {
      adjList[i] = new LinkedList<>();
    }
    tc = new int[vertices][vertices];
  }

  private void addEdge(int u, int v) {
    adjList[u].add(v);
  }

  private void transitiveClosure() {
    for (int i = 0; i < vertices; i++) {
      dfsUtil(i, i);
    }
    for (int i = 0; i < vertices; i++) {
      System.out.println(Arrays.toString(tc[i]));
    }
  }

  private void dfsUtil(int s, int d) {
    tc[s][d] = 1;
    for (Integer adj : adjList[d]) {
      if (tc[s][adj] == 0) {
        dfsUtil(s, adj);
      }
    }
  }

  public static void main(String[] args) {

    // Create a graph given
    // in the above diagram
    Graph g = new Graph(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    System.out.println("Transitive closure " +
        "matrix is");

    g.transitiveClosure();

  }
}
