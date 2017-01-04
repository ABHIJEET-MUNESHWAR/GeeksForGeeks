package com.geeksforgeeks.algorithms.searchingandsorting.sumclosesttoxpair;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 01/01/17
 * Time: 6:46 PM
 * http://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose-sum-closest-x/
 */
public class ClosestPair {
    private void findClosestPair(int[] input1, int[] input2, int size1, int size2, int x) {
        int diff = Integer.MAX_VALUE;
        int l = 0;
        int r = size2 - 1;
        int finalL = 0;
        int finalR = 0;
        while ((l < size1) && (r >= 0)) {
            if (Math.abs(input1[l] + input2[r] - x) < diff) {
                diff = Math.abs(input1[l] + input2[r] - x);
                finalL = l;
                finalR = r;
            }
            if ((input1[l] + input2[r]) < x) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println("The closest pair is: [" + input1[finalL] + ", " + input2[finalR] + "]");
    }

    public static void main(String[] args) {
        ClosestPair closestPair = new ClosestPair();
        int[] input1 = {1, 4, 5, 7};
        int[] input2 = {10, 20, 30, 40};
        int size1 = input1.length;
        int size2 = input2.length;
        int x = 38;
        closestPair.findClosestPair(input1, input2, size1, size2, x);
    }
}
