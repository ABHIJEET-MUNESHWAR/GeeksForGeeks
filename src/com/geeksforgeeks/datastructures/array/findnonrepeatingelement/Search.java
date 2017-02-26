package com.geeksforgeeks.datastructures.array.findnonrepeatingelement;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 25/02/17
 * Time: 6:32 PM
 * http://www.geeksforgeeks.org/find-the-element-that-appears-once-in-a-sorted-array/
 */
public class Search {

    private void search(int[] input, int low, int high) {
        if (low > high) {
            return;
        }
        if (low == high) {
            System.out.println("The element is: " + input[low]);
            return;
        }
        int mid = (low + high) / 2;
        if (mid % 2 == 0) {
            if (input[mid] == input[mid + 1]) {
                search(input, mid + 2, high);
            } else {
                search(input, low, mid);
            }
        } else {
            if (input[mid] == input[mid - 1]) {
                search(input, mid - 2, high);
            } else {
                search(input, low, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        Search search = new Search();
        int[] input = {1, 1, 2, 4, 4, 5, 5, 6, 6};
        int len = input.length;
        search.search(input, 0, len - 1);
    }
}
