package com.geeksforgeeks.datastructures.hashing.countpairswithgivensum;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 25/12/16
 * Time: 12:07 PM
 * http://www.geeksforgeeks.org/count-pairs-with-given-sum/
 */

import java.util.HashMap;

public class CountPairs {
    private void getPairsCount(int[] input, int sum) {
        int counter = 0;
        int size = input.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (hashMap.containsKey(input[i])) {
                hashMap.put(input[i], hashMap.get(input[i]) + 1);
            } else {
                hashMap.put(input[i], 1);
            }
        }
        for (int i = 0; i < size; i++) {
            if (hashMap.containsKey(sum - input[i])) {
                counter += hashMap.get(input[i]);
                if (sum - input[i] == input[i]) {
                    counter--;
                }
            }
        }
        System.out.println(counter / 2);
    }

    public static void main(String args[]) {
        CountPairs countPairs = new CountPairs();
        int[] arr = {1, 5, 7, -1, 5};
        int sum = 6;
        countPairs.getPairsCount(arr, sum);
    }
}
