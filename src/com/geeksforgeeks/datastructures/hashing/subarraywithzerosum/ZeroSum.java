package com.geeksforgeeks.datastructures.hashing.subarraywithzerosum;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 24/12/16
 * Time: 3:27 PM
 * http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
 */

import java.util.HashSet;

public class ZeroSum {
    private boolean isSubArrayWithZeroSum(int[] input) {
        int sum = 0;
        int size = input.length;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            sum += input[i];
            if ((sum == 0) || (input[i] == 0) || (hashSet.contains(sum))) {
                return true;
            }
            hashSet.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6};
        ZeroSum zeroSum = new ZeroSum();
        if (zeroSum.isSubArrayWithZeroSum(arr)) {
            System.out.println("Found a sub array with 0 sum");
        } else {
            System.out.println("No Sub array with 0 sum");
        }
    }
}
