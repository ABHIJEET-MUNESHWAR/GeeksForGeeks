package com.geeksforgeeks.algorithms.dynamic.maximumsumincreasingsubsequence;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 15/01/17
 * Time: 4:12 PM
 */
public class MaximumSumIncreasingSubsequence {
    private int maxSum(int[] arr) {
        int length = arr.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = arr[i];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String args[]) {
        MaximumSumIncreasingSubsequence mss = new MaximumSumIncreasingSubsequence();
        int arr[] = {1, 101, 2, 3, 100, 4, 5};
        int r = mss.maxSum(arr);
        System.out.println(r);
    }
}
