package com.geeksforgeeks.algorithms.backtracking.repeatedpermutation;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 20/03/17
 * Time: 11:05 PM
 */

public class RepeatedPermutation {
    private void findAllPermutations(String str) {
        findPermutation(str, str.length(), "");
    }

    private void findPermutation(String str, int length, String start) {
        int size = start.length();
        if (size == length) {
            System.out.println(start);
        } else {
            for (int i = 0; i < size; i++) {
                findPermutation(String.valueOf(str.charAt(i)), length, start + str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        String str = "ABC";

        RepeatedPermutation permutation = new RepeatedPermutation();
        permutation.findAllPermutations(str);
    }

}
