package com.geeksforgeeks.algorithms.dynamic.MinCoinChange;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    09/09/18,
 * Time:    4:38 PM
 * https://stackoverflow.com/questions/40804598/minimum-number-of-coins-for-a-given-sum-and-denominations
 * https://algorithms.tutorialhorizon.com/dynamic-programming-coin-change-problem/
 */
public class MinCoinChange {

  public static void main(String[] arags) {
    int coins[] = {1, 5, 6, 8};
    int m = coins.length;
    int V = 11;
    System.out.println("Minimum coins required is " + minCoins(coins, m, V));
  }

  private static int minCoins(int[] coins, int totalCoins, int total) {
    int[][] dp = new int[totalCoins + 1][total + 1];
    for (int i = 0; i < totalCoins; i++) {
      dp[i][0] = 0;
    }
    for (int i = 0; i < total + 1; i++) {
      dp[0][i] = i;
    }
    for (int i = 1; i < totalCoins; i++) {
      for (int j = 1; j < total + 1; j++) {
        if (j >= coins[i - 1]) {
          dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[totalCoins][total];
  }

}
