package com.geeksforgeeks.algorithms.searchingandsorting.searchinrotatedsortedarray;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 17/02/17
 * Time: 11:54 AM
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class RotatedSearch {
    private int search(int[] input, int l, int h, int key) {
        if (l > h) {
            return -1;
        }
        int mid = (h + l) / 2;
        if (input[mid] == key) {
            return mid;
        }
        if (input[l] <= input[mid]) {
            if ((input[l] <= key) && (key <= input[mid])) {
                return search(input, l, mid - 1, key);
            }
            return search(input, mid + 1, h, key);
        }
        if ((input[mid] <= key) && (key <= input[h])) {
            return search(input, mid + 1, h, key);
        }
        return search(input, l, mid - 1, key);
    }

    public static void main(String[] args) {
        RotatedSearch rotatedSearch = new RotatedSearch();
        int[] input = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int size = input.length;
        int searchValue = 6;
        int key = rotatedSearch.search(input, 0, size - 1, searchValue);
        if (key == -1) {
            System.out.println("Key isn't found");
        } else {
            System.out.println("Key is found at: " + key);
        }
    }
}
