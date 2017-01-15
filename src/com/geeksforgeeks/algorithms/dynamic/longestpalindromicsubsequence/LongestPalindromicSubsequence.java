package com.geeksforgeeks.algorithms.dynamic.longestpalindromicsubsequence;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 15/01/17
 * Time: 12:50 PM
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {
    private int lps(String str) {
        int length = str.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
                dp[i][i] = 1;
        }
        for (int l = 2; l <= length; l++) {
            for (int i = 0; i < length - l + 1; i++) {
                int j = i + l - 1;
                if ((l == 2) && (str.charAt(i) == str.charAt(j))) {
                    dp[i][j] = 2;
                } else if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }

    public static void main(String args[]) {
        LongestPalindromicSubsequence subsequence = new LongestPalindromicSubsequence();
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        System.out.println("The length of the lps is " + subsequence.lps(seq));
    }
}
