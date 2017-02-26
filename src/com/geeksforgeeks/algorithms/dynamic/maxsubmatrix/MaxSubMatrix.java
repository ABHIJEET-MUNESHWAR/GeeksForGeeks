package com.geeksforgeeks.algorithms.dynamic.maxsubmatrix;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 26/02/17
 * Time: 4:16 PM
 * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class MaxSubMatrix {

    private int min(int a, int b, int c) {
        if ((a < b) && (a < c)) {
            return a;
        } else if ((b < a) && (b < c)) {
            return b;
        } else {
            return c;
        }
    }

    private void printMaxSubSquare(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            result[i][0] = matrix[i][0];
        }
        for (int j = 0; j < col; j++) {
            result[0][j] = matrix[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = matrix[i][j];
                } else {
                    result[i][j] = min(result[i - 1][j], result[i][j - 1], result[i - 1][j - 1]) + 1;
                }
            }
        }
        int max = result[0][0], maxOfI = 0, maxOfJ = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (max < result[i][j]) {
                    max = result[i][j];
                    maxOfI = i;
                    maxOfJ = j;
                }
            }
        }
        System.out.println("Maximum size sub-matrix is: " + max);
        for (int i = maxOfI; i > maxOfI - max; i--) {
            for (int j = maxOfJ; j > maxOfJ - max; j--) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MaxSubMatrix maxSubMatrix = new MaxSubMatrix();
        int[][] matrix = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        maxSubMatrix.printMaxSubSquare(matrix);
    }
}
