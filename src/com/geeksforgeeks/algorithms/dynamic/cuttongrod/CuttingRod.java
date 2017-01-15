package com.geeksforgeeks.algorithms.dynamic.cuttongrod;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 15/01/17
 * Time: 4:04 PM
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 */
public class CuttingRod {
    private int cutRod(int[] price, int n) {
        int[] val = new int[n + 1];
        val[0] = 0;
        for (int i = 1; i <= n; i++) {
            int maxValue = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxValue = Math.max(maxValue, price[j] + val[i - j - 1]);
            }
            val[i] = maxValue;
        }
        return val[n];
    }

    public static void main(String args[]) {
        CuttingRod cuttingRod = new CuttingRod();
        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " + cuttingRod.cutRod(arr, size));
    }
}
