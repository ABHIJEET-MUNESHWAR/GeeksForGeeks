package com.geeksforgeeks.algorithms.backtracking.nqueen;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 11/03/17
 * Time: 5:32 PM
 */
public class NQueen {

    final int N = 5;

    /* A utility function to check if a queen can
       be placed on board[row][col]. Note that this
       function is called when "col" queens are already
       placed in columns from 0 to col -1. So we need
       to check only left side for attacking queens */
    private boolean isSafe(int[][] board, int row, int col) {
        /* Check this row on left side */
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        /* Check upper diagonal on left side */
        for (int i = row, j = col; (i >= 0 && j >= 0); i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        /* Check lower diagonal on left side */
        for (int i = row, j = col; (i < N) && (j >= 0); i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private void printBoard(int[][] board) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    private boolean solveNQueen(int[][] board, int col) {
        if (col >= N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQueen(board, col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        int[][] board = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        boolean isSolvable = nQueen.solveNQueen(board, 0);
        if (isSolvable) {
            nQueen.printBoard(board);
        } else {
            System.out.println("Solution doesn't exist.");
        }
    }
}
