package com.geeksforgeeks.algorithms.dynamic.longestbitonicsubsequence;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 15/01/17
 * Time: 5:21 PM
 * http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/
 */
public class LongestBitonicSubsequence {
    private int lbs(int[] arr, int n) {
        int length = arr.length;
        int[] lis = new int[length];
        int[] lds = new int[length];
        for (int i = 0; i < length; i++) {
            lis[i] = 1;
            lds[i] = 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if ((arr[j] < arr[i]) && (lis[i] < lis[j] + 1)) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = length - 1; j > i; j--) {
                if ((arr[j] < arr[i]) && (lds[i] < lds[j] + 1)) {
                    lds[i] = lds[j] + 1;
                }
            }
        }
        int max = lis[0] + lds[0];
        for (int i = 1; i < length; i++) {
            if (max < (lis[i] + lds[i] - 1)) {
                max = lis[i] + lds[i] + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestBitonicSubsequence subsequence = new LongestBitonicSubsequence();
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
                13, 3, 11, 7, 15};
        int n = arr.length;
        System.out.println("Length of LBS is " + subsequence.lbs(arr, n));
    }
}
