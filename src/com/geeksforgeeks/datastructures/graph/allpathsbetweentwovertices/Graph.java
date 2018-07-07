package com.geeksforgeeks.datastructures.graph.allpathsbetweentwovertices;

import java.util.LinkedList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    07/07/18,
 * Time:    7:28 PM
 */
public class Graph {

  private int vertices;
  private List<Integer>[] adjList;

  Graph(int v) {
    this.vertices = v;
    adjList = new List[v];
    for (int i = 0; i < v; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  void addEdge(int u, int v) {
    adjList[u].add(v);
  }

  // Driver Code
  public static void main(String args[]) {
    Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(0, 3);
    g.addEdge(2, 0);
    g.addEdge(2, 1);
    g.addEdge(1, 3);

    int s = 2, d = 3;
    System.out.println(g.countPaths(s, d));
  }

  private int countPaths(int source, int destination) {
    int pathCount = 0;
    boolean[] visited = new boolean[vertices];
    pathCount = countPathsUtil(source, destination, visited, pathCount);
    return pathCount;
  }

  private int countPathsUtil(int source, int destination, boolean[] visited, int pathCount) {
    visited[source] = true;
    if (source == destination) {
      pathCount++;
    } else {
      for (Integer i : adjList[source]) {
        if (!visited[i]) {
          countPathsUtil(i, destination, visited, pathCount);
        }
      }
    }
    visited[source] = false;
    return pathCount;
  }
}
