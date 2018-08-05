package com.geeksforgeeks.datastructures.graph.minimumedges;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    22/07/18,
 * Time:    9:28 PM
 * https://www.geeksforgeeks.org/minimum-number-of-edges-between-two-vertices-of-a-graph/
 */
public class Graph {

  private int vertices;
  private LinkedList<Integer>[] adjList;

  Graph(int vertices) {
    this.vertices = vertices;
    this.adjList = new LinkedList[vertices];
    for (int i = 0; i < vertices; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  public void addEdge(int source, int destination) {
    adjList[source].add(destination);
  }

  private int findMinEdges(int source, int destination) {
    return findMinEdgesBfsUtil(source, destination);
  }

  private int findMinEdgesBfsUtil(int source, int destination) {
    boolean[] isVisited = new boolean[vertices];
    int[] distance = new int[vertices];
    Queue<Integer> queue = new LinkedList<>();
    isVisited[source] = true;
    queue.add(source);
    while (!queue.isEmpty()) {
      int bfsSource = queue.poll();
      for (Integer i : adjList[bfsSource]) {
        if (!isVisited[i]) {
          distance[i] = distance[bfsSource] + 1;
          isVisited[i] = true;
          queue.add(i);
        }
      }
    }
    return distance[destination];
  }

  public static void main(String[] args) {
    Graph graph = new Graph(9);
    graph.addEdge(0, 1);
    graph.addEdge(0, 7);
    graph.addEdge(1, 7);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(2, 5);
    graph.addEdge(2, 8);
    graph.addEdge(3, 4);
    graph.addEdge(3, 5);
    graph.addEdge(4, 5);
    graph.addEdge(5, 6);
    graph.addEdge(6, 7);
    graph.addEdge(7, 8);
    int minEdges = graph.findMinEdges(0, 5);
    System.out.println("Minimum number of edges are: " + minEdges);
  }

}
