package com.geeksforgeeks.datastructures.graph.weigningscale;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    05/08/18,
 * Time:    7:45 PM
 * https://www.geeksforgeeks.org/move-weighting-scale-alternate-given-constraints/
 */
public class Graph {

  public static void main(String[] args) {
    int[] weights = {2, 3, 5, 6};
    int noOfWeights = weights.length;
    int steps = 10;
    printWeightsOnScale(weights, noOfWeights, steps);
  }

  private static void printWeightsOnScale(int[] input, int noOfWeights, int steps) {
    int[] weights = new int[steps];
    if (dfs(0, 1, weights, input, noOfWeights, steps)) {
      for (int i = 0; i < steps; i++) {
        System.out.println(weights[i]);
      }
    } else {
      System.out.println("Not possible");
    }
  }

  private static boolean dfs(int residue, int currSteps, int[] weights, int[] input,
      int noOfWeights, int steps) {
    if (currSteps >= steps) {
      return true;
    }
    for (int i = 0; i < noOfWeights; i++) {
      if (input[i] > residue && input[i] != weights[currSteps - 1]) {
        weights[currSteps] = input[i];
        if (dfs(input[i] - residue, currSteps + 1, weights, input, noOfWeights, steps)) {
          return true;
        }
      }
    }
    return false;
  }
}
