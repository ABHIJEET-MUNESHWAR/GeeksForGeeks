package com.geeksforgeeks.datastructures.hashing.pairsum;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 11/12/16
 * Time: 12:35 PM
 * http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 */
public class PairSum {
    private static void printPairs(int[] input, int sum) {
        boolean[] map = new boolean[10000];
        for (int i = 0; i < input.length; i++) {
            int t = sum - input[i];
            if ((t >= 0) && (map[t])) {
                System.out.println("Pair with given sum " + sum + " is: " + t + " & " + input[i]);
            }
            map[input[i]] = true;
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 4, 45, 6, 10, 8};
        int n = 16;
        printPairs(input, n);
    }
}
