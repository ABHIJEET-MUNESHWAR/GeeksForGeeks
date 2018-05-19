package com.geeksforgeeks.algorithms.dynamic.maximumcontiguoussumsize;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    19/05/18,
 * Time:    9:04 PM
 */
public class MaxContSumSize {

  public static void main(String[] args) {
    int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
    System.out.println("Maximum contiguous sum size is " + maxSubArraySumSize(a));
  }

  private static int maxSubArraySumSize(int[] input) {
    int maxSumSoFar = 0;
    int maxSumEndingHere = 0;
    int start = 0;
    int end = 0;
    int size = input.length;
    for (int i = 0; i < size; i++) {
      maxSumEndingHere += input[i];
      if (maxSumEndingHere < 0) {
        maxSumEndingHere = 0;
        start = i;
      }
      if (maxSumSoFar < maxSumEndingHere) {
        maxSumSoFar = maxSumEndingHere;
        end = i;
      }
    }
    return (end - start);
  }
}
