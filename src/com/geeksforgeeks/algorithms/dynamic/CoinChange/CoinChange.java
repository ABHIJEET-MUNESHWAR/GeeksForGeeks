package com.geeksforgeeks.algorithms.dynamic.CoinChange;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 14/01/17
 * Time: 11:55 AM
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 */
public class CoinChange {
    private int countWays(int[] coins, int size, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < size; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int sum = 4;
        System.out.println(coinChange.countWays(arr, m, sum));
    }
}
