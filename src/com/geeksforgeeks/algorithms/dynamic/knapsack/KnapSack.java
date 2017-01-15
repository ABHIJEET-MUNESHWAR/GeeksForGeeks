package com.geeksforgeeks.algorithms.dynamic.knapsack;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 14/01/17
 * Time: 4:29 PM
 */
public class KnapSack {
    private int knapSack(int W, int wt[], int val[], int n) {
        int[][] k = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if ((i == 0) || (w == 0)) {
                    k[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    k[i][w] = Math.max(val[i - 1] + k[i - 1][w - wt[i - 1]], k[i - 1][w]);
                } else {
                    k[i][w] = k[i - 1][w];
                }
            }
        }
        return k[n][W];
    }

    public static void main(String[] args) {
        KnapSack sack = new KnapSack();
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(sack.knapSack(W, wt, val, n));
    }
}
