package com.geeksforgeeks.datastructures.hashing.symmetricpairs;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 11/12/16
 * Time: 4:34 PM
 */

import java.util.HashMap;

public class SymmetricPairs {
    private void findSymPairs(int[][] input) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int size = input.length;
        for (int i = 0; i < size; i++) {
            int first = input[i][0];
            int second = input[i][1];
            Integer val = hashMap.get(second);
            if ((val != null) && (val == first)) {
                System.out.println("(" + second + ", " + first + ")");
            } else {
                hashMap.put(first, second);
            }
        }
    }

    public static void main(String[] args) {
        SymmetricPairs symmetricPairs = new SymmetricPairs();
        int arr[][] = new int[5][2];
        arr[0][0] = 11;
        arr[0][1] = 20;
        arr[1][0] = 30;
        arr[1][1] = 40;
        arr[2][0] = 5;
        arr[2][1] = 10;
        arr[3][0] = 40;
        arr[3][1] = 30;
        arr[4][0] = 10;
        arr[4][1] = 5;
        symmetricPairs.findSymPairs(arr);
    }
}
