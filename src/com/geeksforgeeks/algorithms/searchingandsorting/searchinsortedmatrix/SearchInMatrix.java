package com.geeksforgeeks.algorithms.searchingandsorting.searchinsortedmatrix;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 03/01/17
 * Time: 9:08 AM
 * http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 */
public class SearchInMatrix {
    private void searchInMatrix(int[][] matrix, int size, int x) {
        int i = 0;
        int j = size - 1;
        while ((i < size) && (j >= 0)) {
            if (matrix[i][j] == x) {
                System.out.println("Found at: " + i + " & " + j);
                return;
            }
            if (matrix[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }
        return;
    }

    public static void main(String[] args) {
        SearchInMatrix searchInMatrix = new SearchInMatrix();
        int[][] mat = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
        };
        searchInMatrix.searchInMatrix(mat, 4, 29);
    }
}
