package com.geeksforgeeks.datastructures.graph.kcores;

import java.util.LinkedList;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    01/07/18,
 * Time:    5:01 PM
 */
public class Graph {

  private int vertices;
  private LinkedList<Integer>[] adjList;

  Graph(int v) {
    this.vertices = v;
    adjList = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  private void addEdge(int u, int v) {
    adjList[u].add(v);
    adjList[v].add(u);
  }

  public static void main(String[] args) {
    Graph graph = new Graph(9);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(1, 5);
    graph.addEdge(2, 3);
    graph.addEdge(2, 4);
    graph.addEdge(2, 5);
    graph.addEdge(2, 6);
    graph.addEdge(3, 4);
    graph.addEdge(3, 6);
    graph.addEdge(3, 7);
    graph.addEdge(4, 6);
    graph.addEdge(4, 7);
    graph.addEdge(5, 6);
    graph.addEdge(5, 8);
    graph.addEdge(6, 7);
    graph.addEdge(6, 8);
    graph.printKCores(3);
  }

  private void printKCores(int k) {
    boolean[] isVisited = new boolean[vertices];
    int minDeg = Integer.MAX_VALUE;
    int startVertex = 0;
    int[] vertexDegree = new int[vertices];
    for (int i = 0; i < vertices; i++) {
      vertexDegree[i] = adjList[i].size();
      if (vertexDegree[i] < minDeg) {
        minDeg = vertexDegree[i];
        startVertex = i;
      }
    }
    dfsUtil(startVertex, isVisited, vertexDegree, k);

    for (int i = 0; i < vertices; i++) {
      if (!isVisited[i]) {
        dfsUtil(startVertex, isVisited, vertexDegree, k);
      }
    }

    // printing K cores.
    for (int i = 0; i < vertices; i++) {
      if (vertexDegree[i] >= k) {
        System.out.print("[" + i + "] --> ");
        for (Integer j : adjList[i]) {
          if (vertexDegree[j] >= k) {
            System.out.print(j + " ");
          }
        }
        System.out.println();
      }
    }
  }

  private boolean dfsUtil(int startVertex, boolean[] isVisited, int[] vertexDegree, int k) {
    isVisited[startVertex] = true;

    for (Integer i : adjList[startVertex]) {
      if (vertexDegree[startVertex] < k) {
        vertexDegree[i]--;
      }
      if (!isVisited[i]) {
        if (dfsUtil(i, isVisited, vertexDegree, k)) {
          vertexDegree[startVertex]--;
        }
      }
    }
    return vertexDegree[startVertex] < k;
  }
}
