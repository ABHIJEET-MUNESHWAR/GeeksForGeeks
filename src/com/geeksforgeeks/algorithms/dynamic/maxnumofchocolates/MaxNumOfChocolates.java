package com.geeksforgeeks.algorithms.dynamic.maxnumofchocolates;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    19/05/18,
 * Time:    11:10 PM
 */
public class MaxNumOfChocolates {

  public static void main(String[] args) {
    int arr[] = {2, 7, 6, 1, 4, 5};
    int n = arr.length;
    int k = 3;
    System.out.println("Maximum number of chocolates: " + maxNumOfChocolates(arr, n, k));
  }

  private static int maxNumOfChocolates(int[] input, int size, int students) {
    int[] sumArray = new int[size];
    sumArray[0] = input[0];
    int maxSum = 0;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 1; i < size; i++) {
      sumArray[i] = sumArray[i - 1] + input[i];
    }
    for (int i = 0; i < size; i++) {
      int currentRemainder = sumArray[i] % students;
      if (currentRemainder == 0) {
        maxSum = sumArray[i];
      } else if (!hashMap.containsKey(currentRemainder)) {
        hashMap.put(currentRemainder, i);
      } else {
        if (maxSum < (sumArray[i] - sumArray[hashMap.get(currentRemainder)])) {
          maxSum = sumArray[i] - sumArray[hashMap.get(currentRemainder)];
        }
      }
    }
    return maxSum / students;
  }
}
