package com.geeksforgeeks.datastructures.hashing.pairsofequalsum;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 11/12/16
 * Time: 4:19 PM
 * http://www.geeksforgeeks.org/find-four-elements-a-b-c-and-d-in-an-array-such-that-ab-cd/
 */

class Pair {
    int first, second;

    Pair(int a, int b) {
        first = a;
        second = b;
    }
}

public class PairsOfEqualSum {
    private void findPairs(int[] input) {
        HashMap<Integer, Pair> hashMap = new HashMap<>();
        int size = input.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int sum = input[i] + input[j];
                if (hashMap.containsKey(sum)) {
                    Pair p = hashMap.get(sum);
                    System.out.println("(" + p.first + ", " + p.second + ") and (" + input[i] + ", " + input[j] + ")");
                } else {
                    hashMap.put(sum, new Pair(input[i], input[j]));
                }
            }
        }
    }

    public static void main(String[] args) {
        PairsOfEqualSum pairsOfEqualSum = new PairsOfEqualSum();
        int[] input = {3, 4, 7, 1, 2, 9, 8};
        pairsOfEqualSum.findPairs(input);
    }
}
