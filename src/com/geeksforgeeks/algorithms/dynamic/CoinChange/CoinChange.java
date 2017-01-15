package com.geeksforgeeks.algorithms.dynamic.CoinChange;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 14/01/17
 * Time: 11:55 AM
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 */
public class CoinChange {
    private int countWays(int[] arr, int m, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = arr[i]; j <= n; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 4;
        System.out.println(coinChange.countWays(arr, m, n));
    }
}
