package com.geeksforgeeks.algorithms.searchingandsorting.findcommon;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 01/01/17
 * Time: 10:48 PM
 * http://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/
 */
public class FindCommon {
    private void findCommon(int[] arr1, int[] arr2, int[] arr3) {
        int size1 = arr1.length;
        int size2 = arr2.length;
        int size3 = arr3.length;
        int i = 0, j = 0, k = 0;
        while ((i < size1) && (j < size2) && (k < size3)) {
            if ((arr1[i] == arr2[j]) && (arr2[j] == arr3[k])) {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
    }

    public static void main(String[] args) {
        FindCommon findCommon = new FindCommon();
        int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 7, 20, 80, 100};
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};

        System.out.print("Common elements are ");
        findCommon.findCommon(ar1, ar2, ar3);
    }
}
