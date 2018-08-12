package com.geeksforgeeks.algorithms.dynamic.maxpathsuminmatrix;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    12/08/18,
 * Time:    4:27 PM
 * https://www.geeksforgeeks.org/maximum-path-sum-matrix/
 */
public class MaxPathSum {

  public static void main(String[] args) {
    int mat[][] = {{10, 10, 2, 0, 20, 4},
        {1, 0, 0, 30, 2, 5},
        {0, 10, 4, 0, 2, 0},
        {1, 0, 2, 20, 0, 4}
    };

    System.out.println(findMaxPath(mat));
  }

  private static int findMaxPath(int[][] matrix) {
    int result = 0;
    int rowLength = matrix.length;
    int colLength = matrix[0].length;
    for (int i = 1; i < rowLength; i++) {
      for (int j = 0; j < colLength; j++) {
        if (j > 0 && j < colLength - 1) {
          matrix[i][j] += Math
              .max(matrix[i - 1][j], Math.max(matrix[i - 1][j-1], matrix[i - 1][j + 1]));
        }
        else if (j > 0) {
          matrix[i][j] += Math.max(matrix[i - 1][j - 1], matrix[i - 1][j]);
        }
        else if (j < colLength - 1) {
          matrix[i][j] += Math.max(matrix[i - 1][j], matrix[i - 1][j + 1]);
        }
        result = Math.max(result, matrix[i][j]);
      }
    }
    return result;
  }
}
