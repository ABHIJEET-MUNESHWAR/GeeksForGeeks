package com.geeksforgeeks.datastructures.array.maximumrepeatingelement;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 28/03/17
 * Time: 11:06 PM
 * http://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
 */
public class MaxRepeating {

    private int maxRepeating(int[] arr, int n, int k) {
        for (int i = 0; i < n; i++) {
            arr[arr[i] % k] += k;
        }
        int max = arr[0];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxRepeating maxRepeating = new MaxRepeating();
        int arr[] = {2, 3, 3, 5, 3, 4, 1, 7};
        int n = arr.length;
        int k = 8;
        System.out.println("Maximum repeating element is: " +
                maxRepeating.maxRepeating(arr, n, k));
    }
}
