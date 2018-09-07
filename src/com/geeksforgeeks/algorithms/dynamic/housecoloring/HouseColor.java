package com.geeksforgeeks.algorithms.dynamic.housecoloring;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    07/09/18,
 * Time:    4:49 PM
 * http://karmaandcoding.blogspot.com/2012/02/house-coloring-with-red-blue-and-green.html
 */
public class HouseColor {

  public static void main(String[] args) {
    int[][] costMatrix = {{7, 5, 10},
        {3, 6, 1},
        {8, 7, 4},
        {6, 2, 9},
        {1, 4, 7},
        {2, 3, 6},
    };
    int cost = calcHouseColoringCost(costMatrix);
    System.out.println("Cost of coloring the house is: " + cost);
  }

  private static int calcHouseColoringCost(int[][] costMatrix) {
    int rows = costMatrix.length + 1;
    int cols = costMatrix[0].length + 1;
    int[][] cost = new int[rows][cols];
    for (int i = 1; i < rows; i++) {
      cost[i][0] = Math.min(cost[i - 1][1], cost[i - 1][2]) + costMatrix[i - 1][0];
      cost[i][1] = Math.min(cost[i - 1][0], cost[i - 1][2]) + costMatrix[i - 1][1];
      cost[i][2] = Math.min(cost[i - 1][0], cost[i - 1][1]) + costMatrix[i - 1][2];
    }
    int finalCost = Math.min(Math.min(cost[rows - 1][0], cost[rows - 1][1]), cost[rows - 1][2]);
    return finalCost;
  }

  public static void printMatrix(int[][] M) {
    int r = M.length;
    int c = M[0].length;

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        System.out.print(M[i][j] + " ");
      }
      System.out.println();
    }
  }
}