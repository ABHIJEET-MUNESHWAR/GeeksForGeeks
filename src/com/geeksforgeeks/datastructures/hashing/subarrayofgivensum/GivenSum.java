package com.geeksforgeeks.datastructures.hashing.subarrayofgivensum;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 24/12/16
 * Time: 7:50 PM
 * http://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
 */

import java.util.HashMap;

public class GivenSum {
    private void findSubArrayOfGivenSum(int[] input, int sum) {
        int currSum = 0;
        int size = input.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            currSum += input[i];
            if (currSum == sum) {
                System.out.println("Sum found between indices 0 and " + i);
            }
            if (hashMap.get(sum - currSum) != null) {
                System.out.println("Sum found between indices " + (hashMap.get(sum - currSum) + 1) + " and " + i);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        int sum = -10;
        GivenSum givenSum = new GivenSum();
        givenSum.findSubArrayOfGivenSum(arr, sum);
    }
}
