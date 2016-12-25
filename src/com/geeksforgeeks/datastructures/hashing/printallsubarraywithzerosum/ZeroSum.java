package com.geeksforgeeks.datastructures.hashing.printallsubarraywithzerosum;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 24/12/16
 * Time: 6:14 PM
 * http://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
 */

import java.util.HashMap;

public class ZeroSum {
    private void findZeroSumSubArrays(int[] input) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int size = input.length;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += input[i];
            if (sum == 0) {
                printSubArray(input, 0, i);
            } else if (hashMap.get(sum) != null) {
                printSubArray(input, hashMap.get(sum) + 1, i);
            } else {
                hashMap.put(sum, i);
            }
        }
    }

    private void printSubArray(int[] input, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,-9,6,7,-8,1,9};
        ZeroSum zeroSum = new ZeroSum();
        zeroSum.findZeroSumSubArrays(arr);
    }
}
