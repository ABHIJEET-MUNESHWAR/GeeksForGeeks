package com.geeksforgeeks.datastructures.array.subarraywithsum;

/**
 * Created using IntelliJ IDEA
 * User: Abhijeet
 * Date: 10-04-2017
 * Time: 03:49 PM
 * http://www.geeksforgeeks.org/find-subarray-with-given-sum/
 */
public class SubArraySum {

    private void subArraySum(int[] arr, int n, int sum) {
        int currSum = arr[0], start = 0;
        for (int i = 1; i <= n; i++) {
            while ((currSum > sum) && (start < (i - 1))) {
                currSum = currSum - arr[start];
                start++;
            }
            if (currSum == sum) {
                System.out.println("Sum is found at index " + start + " and " + (i - 1));
                break;
            }
            if (i < n) {
                currSum = currSum + arr[i];
            }
        }
    }

    public static void main(String[] args) {
        SubArraySum arraySum = new SubArraySum();
        int         arr[]    = {15, 2, 4, 8, 9, 5, 10, 23};
        int         n        = arr.length;
        int         sum      = 23;
        arraySum.subArraySum(arr, n, sum);
    }
}
