package com.geeksforgeeks.datastructures.stack.nextgreaterelement;

/**
 * Created by Abhijeet on 22/10/16.
 * http://www.geeksforgeeks.org/next-greater-element/
 */

import java.util.*;

public class NextGreaterElement {
    private void printNGE(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr[0]);
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            if ((!stack.isEmpty()) && (arr[i] <= stack.peek())) {
                stack.push(arr[i]);
            } else {
                while ((!stack.isEmpty()) && (arr[i] > stack.peek())) {
                    System.out.println("NGE of " + stack.pop() + " is: " + arr[i]);
                }
                stack.push(arr[i]);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println("NGE of " + stack.pop() + " is: -1");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 25};
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        nextGreaterElement.printNGE(arr);
    }
}
