package com.geeksforgeeks.algorithms.dynamic.binomialcoefficient;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 14/01/17
 * Time: 2:51 PM
 */
public class BinomialCoefficient {
    private int binomialCoeff(int n, int k) {
        int[][] c = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if ((j == 0) || (j == i)) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
                }
            }
        }
        return c[n][k];
    }

    public static void main(String[] args) {
        BinomialCoefficient coefficient = new BinomialCoefficient();
        int n = 5, k = 2;
        System.out.println("Value of C(" + n + "," + k + ") is " + coefficient.binomialCoeff(n, k));
    }
}
