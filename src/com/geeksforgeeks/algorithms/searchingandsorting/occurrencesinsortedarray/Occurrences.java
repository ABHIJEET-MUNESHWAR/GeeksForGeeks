package com.geeksforgeeks.algorithms.searchingandsorting.occurrencesinsortedarray;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 03/01/17
 * Time: 11:16 PM
 * http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/
 */
public class Occurrences {
    private int first(int[] input, int low, int high, int x) {
        int mid = low + (high - low) / 2;
        if ((mid == 0) || (input[mid - 1] < x) && (input[mid] == x)) {
            return mid;
        } else if (input[mid] < x) {
            return first(input, mid + 1, high, x);
        } else {
            return first(input, low, mid - 1, x);
        }
    }

    private int last(int[] input, int low, int high, int x) {
        int mid = low + (high - low) / 2;
        if ((mid == high - 1) || (x < input[mid + 1]) && (x == input[mid])) {
            return mid;
        } else if (x < input[mid]) {
            return last(input, low, mid - 1, x);
        } else {
            return last(input, mid + 1, high, x);
        }
    }

    private int countOccurrences(int[] input, int size, int x) {
        int first = first(input, 0, size, x);
        int last = last(input, 0, size, x);
        return (last - first + 1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 3, 3, 3};
        int x = 3;
        int size = arr.length;
        Occurrences occurrences = new Occurrences();
        int count = occurrences.countOccurrences(arr, size, x);
        System.out.println(x + " occurs " + count + " times.");
    }
}
