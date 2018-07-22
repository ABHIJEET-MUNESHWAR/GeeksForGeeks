package com.geeksforgeeks.datastructures.graph.allpathsbetweentwovertices.dfs;

import java.util.LinkedList;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    22/07/18,
 * Time:    6:30 PM
 * https://www.geeksforgeeks.org/find-paths-given-source-destination/
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

  // Driver program
  public static void main(String[] args) {
    // Create a sample graph
    Graph graph = new Graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(0, 3);
    graph.addEdge(2, 0);
    graph.addEdge(2, 1);
    graph.addEdge(1, 3);

    // arbitrary source
    int s = 2;

    // arbitrary destination
    int d = 3;

    System.out.println("Following are all different paths from " + s + " to " + d);
    graph.printAllPaths(s, d);

  }

  private void printAllPaths(int s, int d) {
    boolean[] isVisited = new boolean[vertices];
    LinkedList<Integer> pathList = new LinkedList<>();
    pathList.add(s);
    printAllPathsDfs(s, d, isVisited, pathList);
  }

  private void printAllPathsDfs(int source, int destination, boolean[] isVisited,
      LinkedList<Integer> pathList) {
    isVisited[source] = true;
    if (source == destination) {
      System.out.println(pathList);
    }
    for (Integer i : adjList[source]) {
      if (!isVisited[i]) {
        pathList.add(i);
        isVisited[i] = true;
        printAllPathsDfs(i, destination, isVisited, pathList);
        pathList.remove(i);
      }
    }
    isVisited[source] = false;
  }
}