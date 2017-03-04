package com.geeksforgeeks.algorithms.searchingandsorting.majorityofelementinsortedarray;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/03/17
 * Time: 11:36 PM
 * http://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/
 */
public class Majority {

    private int binarySearch(int[] arr, int low, int high, int x) {
        if (high >= low)
        {
            int mid = (low + high)/2;  /*low + (high - low)/2;*/

            /* Check if arr[mid] is the first occurrence of x.
                arr[mid] is first occurrence if x is one of the following
                is true:
                (i)  mid == 0 and arr[mid] == x
                (ii) arr[mid-1] < x and arr[mid] == x
            */
            if ( (mid == 0 || x > arr[mid-1]) && (arr[mid] == x) )
                return mid;
            else if (x > arr[mid])
                return binarySearch(arr, (mid + 1), high, x);
            else
                return binarySearch(arr, low, (mid -1), x);
        }

        return -1;
    }

    private boolean isMajority(int[] arr, int n, int x) {
        int start = binarySearch(arr, 0, n - 1, x);
        if (start == -1) {
            return false;
        }
        if (((start + n / 2) < n) && (arr[start + n / 2] == x)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Majority majority = new Majority();
        int arr[] = {1, 2, 3, 3, 3, 3, 10};
        int n = arr.length;
        int x = 3;
        if (majority.isMajority(arr, n, x)) {
            System.out.println(x + " appears more than " +
                    n / 2 + " times in arr[]");
        } else {
            System.out.println(x + " does not appear more than " +
                    n / 2 + " times in arr[]");
        }
    }
}
