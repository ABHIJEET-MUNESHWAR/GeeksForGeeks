package com.geeksforgeeks.algorithms.searchingandsorting.floorinsortedarray;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 02/01/17
 * Time: 11:28 PM
 */
public class FindFloor {
    private int floorSearch(int arr[], int low, int high, int x) {
        // If low and high cross each other
        if (low > high)
            return -1;

        // If last element is smaller than x
        if (x >= arr[high])
            return high;

        // Find the middle point
        int mid = (low + high) / 2;

        // If middle point is floor.
        if (arr[mid] == x)
            return mid;

        // If x lies between mid-1 and mid
        if (mid > 0 && arr[mid - 1] <= x && x < arr[mid])
            return mid - 1;

        // If x is smaller than mid, floor must be in
        // left half.
        if (x < arr[mid])
            return floorSearch(arr, low, mid - 1, x);

        // If mid-1 is not floor and x is greater than
        // arr[mid],
        return floorSearch(arr, mid + 1, high, x);
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 4, 6, 10, 12, 14};
        int size = input.length;
        int x = 7;
        FindFloor findFloor = new FindFloor();
        int index = findFloor.floorSearch(input, 0, size - 1, x);
        if (index == -1)
            System.out.println("Floor of " + x + " doesn't exist in array ");
        else
            System.out.println("Floor of " + x + " is: " + input[index]);
    }
}
