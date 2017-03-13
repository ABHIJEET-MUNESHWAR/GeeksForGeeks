package com.geeksforgeeks.datastructures.array.booleanmatrix;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 13/03/17
 * Time: 3:37 PM
 * http://www.geeksforgeeks.org/a-boolean-matrix-question/
 */
public class BooleanMatrix {
    final int ROW = 4;
    final int COL = 4;

    private void updateMatrix(int[][] matrix) {
        int[] rows = new int[ROW];
        int[] cols = new int[COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (matrix[i][j] == 1) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if ((rows[i] == 1) || (cols[j] == 1)) {
                    matrix[i][j] = 1;
                }
            }
        }
    }

    private void printMatrix(int[][] mat) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BooleanMatrix booleanMatrix = new BooleanMatrix();
        int[][] mat = {{1, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        booleanMatrix.printMatrix(mat);
        booleanMatrix.updateMatrix(mat);
        booleanMatrix.printMatrix(mat);
    }
}
