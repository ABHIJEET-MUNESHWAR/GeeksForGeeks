package com.geeksforgeeks.algorithms.searchingandsorting.numberofoccurrences;

/**
 * Created using IntelliJ IDEA
 * User: Abhijeet
 * Date: 09-04-2017
 * Time: 06:52 PM
 * http://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
 */
public class NoOfOccurrences {

    private int first(int[] input, int low, int high, int n, int key) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (key < input[mid]) {
                return first(input, low, mid - 1, n, key);
            } else if (key > input[mid]) {
                return first(input, mid + 1, high, n, key);
            } else {
                if ((mid == 0) || (input[mid - 1] < key)) {
                    return mid;
                }
            }
        }
        return -1;
    }

    private int last(int[] input, int low, int high, int n, int key) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (key < input[mid]) {
                return last(input, low, mid - 1, n, key);
            } else if (key > input[mid]) {
                return last(input, mid + 1, high, n, key);
            } else {
                if ((mid == (n - 1)) || (input[mid + 1] > key)) {
                    return mid;
                }
            }
        }
        return -1;
    }

    private int findOccurrences(int[] input, int key) {
        int n = input.length;
        int i = first(input, 0, n - 1, n, key);
        if (i == -1) {
            return i;
        }
        int j = last(input, 0, n - 1, n, key);
        return (j - i + 1);
    }

    public static void main(String[] args) {
        NoOfOccurrences occurrences = new NoOfOccurrences();
        int[]           input       = {1, 2, 2, 3, 3, 3, 3};
        int             key         = 3;
        int             c           = occurrences.findOccurrences(input, key);
        System.out.println(c);
    }
}
