package com.geeksforgeeks.datastructures.hashing.checkduplicateswithin;

import java.util.HashSet;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 11/12/16
 * Time: 2:05 PM
 * http://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
 */

public class CheckDuplicates {
    private boolean checkDuplicatesWithinK(int[] input, int k) {
        HashSet<Integer> hashSet = new HashSet();
        for (int i = 0; i < input.length; i++) {
            if (hashSet.contains(input[i])) {
                return true;
            }
            hashSet.add(input[i]);
            if (i >= k) {
                hashSet.remove(input[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckDuplicates duplicates = new CheckDuplicates();
        int[] input = {10, 5, 3, 4, 3, 5, 6};
        if (duplicates.checkDuplicatesWithinK(input, 3))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
