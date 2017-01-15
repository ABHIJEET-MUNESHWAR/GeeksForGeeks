package com.geeksforgeeks.algorithms.dynamic.longestincreasingsubsequence;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 12/01/17
 * Time: 9:44 PM
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 */
public class LIS {
    /**
     *
     * @param input
     * @return
     */
    private int lis(int[] input) {
        int size = input.length;
        int[] lis = new int[size];
        int i, j, max = 0;
        for (i = 0; i < size; i++) {
            lis[i] = 1;
        }
        for (i = 1; i < size; i++) {
            for (j = 0; j < i; j++) {
                if ((input[j] < input[i]) && (lis[i] < lis[j] + 1)) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        for (i = 0; i < size; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        LIS lis = new LIS();
        System.out.println("Length of lis is " + lis.lis(arr));
    }
}
