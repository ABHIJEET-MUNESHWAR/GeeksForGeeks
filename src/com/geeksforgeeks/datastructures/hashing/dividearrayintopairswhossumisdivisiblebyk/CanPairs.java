package com.geeksforgeeks.datastructures.hashing.dividearrayintopairswhossumisdivisiblebyk;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 11/12/16
 * Time: 3:42 PM
 */
public class CanPairs {
    private boolean canPairs(int[] input, int k) {
        int size = input.length;
        if (size % 2 == 1) {
            return false;
        }
        int[] frequencyMap = new int[10000];
        // Graph occurrences of all remainders
        for (int i = 0; i < size; i++) {
            frequencyMap[input[i] % k]++;
        }

        // Traverse input and use frequencyMap[] to decide
        // if given input can be divided in pairs
        for (int i = 0; i < size; i++) {
            // Remainder of current element
            int rem = input[i] % k;

            // If remainder with current element divides
            // k into two halves.
            if (2 * rem == k) {
                // Then there must be even occurrences of
                // such remainder
                if (frequencyMap[rem] % 2 != 0) {
                    return false;
                }
            }

            // If remainder is 0, then there must be two 
            // elements with 0 remainder
            else if (rem == 0) {
                if (frequencyMap[rem] % 2 == 1) {
                    return false;
                }
            }

            // Else number of occurrences of remainder
            // must be equal to number of occurrences of
            // k - remainder
            else if (frequencyMap[rem] != frequencyMap[k - rem]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanPairs canPairs = new CanPairs();
        int[] input = {9, 7, 5, 3};
        int k = 6;
        if (canPairs.canPairs(input, k)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
