package com.geeksforgeeks.datastructures.hashing.largestsubarraywithzerosum;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 11/12/16
 * Time: 5:49 PM
 */

import java.util.HashMap;

public class ZeroSum {
    private int maxLen(int[] input) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        int sum = 0;
        int maxLen = 0;
        int size = input.length;
        for (int i = 0; i < size; i++) {
            sum += input[i];
            if (input[i] == 0 && maxLen == 0) {
                maxLen = 1;
            }
            if (sum == 0) {
                maxLen = i + 1;
            }
            Integer lastI = hashMap.get(sum);
            if (lastI != null) {
                maxLen = Math.max(maxLen, i - lastI);
            } else {
                hashMap.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String arg[]) {
        ZeroSum zeroSum = new ZeroSum();
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of the longest 0 sum subarray is "
                + zeroSum.maxLen(arr));
    }
}
