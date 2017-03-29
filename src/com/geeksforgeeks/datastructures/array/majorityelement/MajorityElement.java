package com.geeksforgeeks.datastructures.array.majorityelement;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 28/03/17
 * Time: 11:13 PM
 * http://www.geeksforgeeks.org/majority-element/
 */
public class MajorityElement {

    private int findCandidate(int[] input, int size) {
        int majorityIndex = 0;
        int count = 1;
        for (int i = 0; i < size; i++) {
            if (input[i] == input[majorityIndex]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majorityIndex = i;
            }
        }
        return input[majorityIndex];
    }

    private boolean isMajority(int[] input, int size, int candidate) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (input[i] == candidate) {
                count++;
            }
        }
        if (count > (size / 2)) {
            return true;
        } else {
            return false;
        }
    }

    private void printMajority(int[] input, int size) {
        int candidate = findCandidate(input, size);
        if (isMajority(input, size, candidate)) {
            System.out.println(" " + candidate + " ");
        } else {
            System.out.println("No Majority Element");
        }

    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int a[] = new int[]{1, 3, 3, 1, 2};
        int size = a.length;
        majorityElement.printMajority(a, size);
    }
}
