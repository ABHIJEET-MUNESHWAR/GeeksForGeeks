package com.geeksforgeeks.datastructures.array.minimumsubarraysum;

/**
 * Created using IntelliJ IDEA
 * User: Abhijeet
 * Date: 10-04-2017
 * Time: 11:19 PM
 * http://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 */
public class MinimumSubArraySum {

    private int smallestSubWithSum(int[] input, int size, int key) {
        int minLength = size + 1;
        for (int start = 0; start < size; start++) {
            int currSum = input[start];
            if (currSum > key) {
                return 1;
            }
            for (int end = start + 1; end < size; end++) {
                currSum += input[end];
                if ((currSum > key) && ((end - start + 1) < minLength)) {
                    minLength = end - start + 1;
                }
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        MinimumSubArraySum minimumSubArraySum = new MinimumSubArraySum();

        int arr1[] = {1, 4, 45, 6, 10, 19};
        int x      = 51;
        int n1     = arr1.length;
        int res1   = minimumSubArraySum.smallestSubWithSum(arr1, n1, x);
        if (res1 == n1 + 1)
            System.out.println("Not Possible");
        else
            System.out.println(res1);


        int arr2[] = {1, 10, 5, 2, 7};
        int n2     = arr2.length;
        x = 9;
        int res2 = minimumSubArraySum.smallestSubWithSum(arr2, n2, x);
        if (res2 == n2 + 1)
            System.out.println("Not Possible");
        else
            System.out.println(res2);

        int arr3[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        int n3     = arr3.length;
        x = 280;
        int res3 = minimumSubArraySum.smallestSubWithSum(arr3, n3, x);
        if (res3 == n3 + 1)
            System.out.println("Not Possible");
        else
            System.out.println(res3);
    }
}
