package com.geeksforgeeks.algorithms.dynamic.binomialcoefficient;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 14/01/17
 * Time: 2:58 PM
 */
public class EfficientBinomialCoefficient {
    private int binomialCoeff(int n, int k) {
        int[] c = new int[k + 1];
        c[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--) {
                c[j] = c[j] + c[j - 1];
            }
        }
        return c[k];
    }

    public static void main(String[] args) {
        EfficientBinomialCoefficient coefficient = new EfficientBinomialCoefficient();
        int n = 5, k = 2;
        System.out.println("Value of C(" + n + "," + k + ") is " + coefficient.binomialCoeff(n, k));
    }
}
