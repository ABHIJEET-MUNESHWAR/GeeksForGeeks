package com.geeksforgeeks.algorithms.dynamic.convertstring;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 14/01/17
 * Time: 11:03 AM
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 */
public class ConvertString {
    private int min(int a, int b, int c) {
        if ((a < b) && (a < c)) {
            return a;
        }
        if ((b < a) && (b < c)) {
            return b;
        }
        return c;
    }

    private int convertString(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        ConvertString convertString = new ConvertString();
        String str1 = "sunday";
        String str2 = "saturday";
        int distance = convertString.convertString(str1, str2);
        System.out.println(distance);
    }
}
