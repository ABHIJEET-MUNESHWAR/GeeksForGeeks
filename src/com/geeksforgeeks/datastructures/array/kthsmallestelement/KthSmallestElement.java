package com.geeksforgeeks.datastructures.array.kthsmallestelement;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 11/02/17
 * Time: 5:20 PM
 */
public class KthSmallestElement {
    public static void main(String[] args) {
        int[] list1 = new int[]{3, 4, 10, 23, 45, 55, 56, 58, 60, 65};
        int[] list2 = new int[]{3, 3, 3, 15, 16, 28, 50, 70, 71, 72};
        int k = 13;

        int kthSmallest = kthSmallest(list1, list2, k);
        System.out.println(k + "th smallest is " + kthSmallest);
    }

    public static int kthSmallest(int[] A, int[] B, int k) {
        if (A == null || B == null) {
            throw new IllegalArgumentException("Arrays cannot be null!");
        }

        int a = A.length;
        int b = B.length;

        if (k < 1 || k > a + b) {
            throw new IllegalArgumentException("k is not within range!");
        }

        int minSizeA = Math.max(0, k - b);
        int maxSizeA = Math.min(a, k);

        while (minSizeA <= maxSizeA) {
            int sizeA = minSizeA + (maxSizeA - minSizeA) / 2;
            int sizeB = k - sizeA;
            int indexA = sizeA - 1;
            int indexB = sizeB - 1;
            int indexANext = sizeA;
            int indexBNext = sizeB;
            int valA = (indexA < 0) ? Integer.MIN_VALUE : A[indexA];
            int valB = (indexB < 0) ? Integer.MIN_VALUE : B[indexB];
            int valANext = (indexANext >= a) ? Integer.MAX_VALUE : A[indexANext];
            int valBNext = (indexBNext >= b) ? Integer.MAX_VALUE : B[indexBNext];

            if (valA <= valBNext && valB <= valANext) {
                return Math.max(valA, valB);
            } else if (valA > valBNext) {
                maxSizeA = sizeA - 1;
            } else {
                minSizeA = sizeA + 1;
            }
        }

        return 0;
    }
}