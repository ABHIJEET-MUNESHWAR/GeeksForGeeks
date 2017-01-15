package com.geeksforgeeks.algorithms.dynamic.matrixchainmultiplication;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 14/01/17
 * Time: 12:24 PM
 */
public class MatrixChainMultiplication {
    private int findCost(int[] arr) {
        int size = arr.length;
        int[][] cost = new int[size][size];
        int temp = 0;
        for (int L = 2; L < size; L++) {
            for (int i = 1; i < size - L + 1; i++) {
                int j = i + L - 1;
                if (j == size) {
                    continue;
                }
                cost[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    // q = cost/scalar multiplications
                    int q = cost[i][k] + cost[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (q < cost[i][j]) {
                        cost[i][j] = q;
                    }
                }
            }
        }

        return cost[1][size - 1];
    }

    public static void main(String[] args) {
        MatrixChainMultiplication mcm = new MatrixChainMultiplication();
        int arr[] = {1, 2, 3, 4};
        int cost = mcm.findCost(arr);
        System.out.print(cost);
    }
}
