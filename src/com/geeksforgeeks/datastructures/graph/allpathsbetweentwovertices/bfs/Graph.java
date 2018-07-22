package com.geeksforgeeks.datastructures.graph.allpathsbetweentwovertices.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    22/07/18,
 * Time:    7:33 PM
 */
public class Graph {

  private int vertices;
  private LinkedList<Integer>[] adjList;

  Graph(int v) {
    this.vertices = v;
    this.adjList = new LinkedList[v];
    for (int i = 0; i < vertices; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  public void addEdge(int source, int destination) {
    adjList[source].add(destination);
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

  private void printAllPaths(int source, int destination) {
    printAllPathsBfsUtil(source, destination);
  }

  private void printAllPathsBfsUtil(int source, int destination) {
    LinkedList<Integer> pathList = new LinkedList<>();
    Queue<Integer> queue = new LinkedList<>();
    boolean[] isVisited = new boolean[vertices];
    isVisited[source] = true;
    queue.add(source);
    pathList.add(source);
    while (!queue.isEmpty()) {
      source = queue.poll();
      if (source == destination) {
        System.out.println(pathList);
      }
      for (Integer i : adjList[source]) {
        if (!isVisited[i]) {
          isVisited[i] = true;
          queue.add(i);
          pathList.add(i);
        }
      }
    }
  }
}
