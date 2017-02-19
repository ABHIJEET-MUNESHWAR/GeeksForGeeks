package com.geeksforgeeks.datastructures.array.longestconsecutivesubsequence;

import java.util.HashSet;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 12/02/17
 * Time: 5:11 PM
 */
public class LongestConsecutiveSubsequence {
    private static int findLongestConseqSubseq(int[] arr, int n) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            hashSet.add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (!hashSet.contains(arr[i] - 1)) {
                int j = arr[i];
                while (hashSet.contains(j)) {
                    j++;
                }
                if (ans < j - arr[i]) {
                    ans = j - arr[i];
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = {1, 9, 3, 10, 4, 20, 2};
        int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is " + findLongestConseqSubseq(arr, n));
    }
}
