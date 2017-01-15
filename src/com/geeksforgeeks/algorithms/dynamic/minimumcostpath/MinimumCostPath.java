package com.geeksforgeeks.algorithms.dynamic.minimumcostpath;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 14/01/17
 * Time: 11:43 AM
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 */
public class MinimumCostPath {
    private int min(int a, int b, int c) {
        if ((a < b) && (a < c)) {
            return a;
        }
        if ((b < a) && (b < c)) {
            return b;
        }
        return c;
    }

    private int minCost(int[][] cost, int m, int n) {
        int[][] tc = new int[m + 1][n + 1];
        tc[0][0] = cost[0][0];
        for (int i = 1; i <= m; i++) {
            tc[i][0] = tc[i - 1][0] + cost[i][0];
        }
        for (int j = 1; j <= n; j++) {
            tc[0][j] = tc[0][j - 1] + cost[0][j];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                tc[i][j] = min(tc[i - 1][j], tc[i][j - 1], tc[i - 1][j - 1]) + cost[i][j];
            }
        }
        return tc[m][n];
    }

    public static void main(String[] args) {
        MinimumCostPath minimumCostPath = new MinimumCostPath();
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        System.out.println("minimum cost to reach (2,2) = " + minimumCostPath.minCost(cost, 2, 2));
    }
}
