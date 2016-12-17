package com.geeksforgeeks.datastructures.hashing.longestconsecutivesubsequence;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 15/12/16
 * Time: 9:52 PM
 */

import java.util.HashSet;

public class SonsecutiveSubsequence {
    private static int findLongestConseqSubseq(int[] input, int n) {
        HashSet<Integer> hashSet = new HashSet();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            hashSet.add(input[i]);
        }
        for (int i = 0; i < n; i++) {
            if (!hashSet.contains(input[i] - 1)) {
                int j = input[i];
                while (hashSet.contains(j)) {
                    j++;
                }
                ans = Math.max(ans, j - input[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 9, 3, 10, 4, 20, 2};
        int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is " +
                findLongestConseqSubseq(arr, n));
    }
}
