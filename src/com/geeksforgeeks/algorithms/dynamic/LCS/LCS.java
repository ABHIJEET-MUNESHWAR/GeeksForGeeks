package com.geeksforgeeks.algorithms.dynamic.LCS;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 13/01/17
 * Time: 9:52 PM
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 */
public class LCS {
    private int lcs(char[] c1, char[] c2) {
        int m = c1.length;
        int n = c2.length;
        int[][] lcs = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs[m][n];
    }

    public static void main(String[] args) {
        char[] c1 = {'A', 'G', 'G', 'T', 'A', 'B'};
        char[] c2 = {'G', 'X', 'T', 'X', 'A', 'Y', 'B'};
        LCS lcs = new LCS();
        System.out.println(lcs.lcs(c1, c2));
    }
}
