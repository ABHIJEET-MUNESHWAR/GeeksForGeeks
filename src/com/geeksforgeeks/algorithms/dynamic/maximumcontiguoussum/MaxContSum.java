package com.geeksforgeeks.algorithms.dynamic.maximumcontiguoussum;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 12/02/17
 * Time: 4:11 PM
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class MaxContSum {
    private static int maxSubArraySum(int[] a) {
        int size = a.length;
        int maxSoFar = a[0];
        int currMax = a[0];
        for (int i = 1; i < size; i++) {
            currMax = Math.max(a[i], currMax + a[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
    }

}
