package com.geeksforgeeks.algorithms.backtracking.permutation;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 12/02/17
 * Time: 5:32 PM
 */
public class Permutation {
    private void findAllPermutations(String str) {
        findPermutation("", str);
    }

    private void findPermutation(String prefix, String str) {
        int size = str.length();
        if (size == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < size; i++) {
                findPermutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, size));
            }
        }
    }

    public static void main(String[] args) {
        String str = "123";
        Permutation permutation = new Permutation();
        permutation.findAllPermutations(str);
    }

}
