package com.geeksforgeeks.datastructures.stack.largestrectangulararea;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 08/11/16
 * Time: 7:49 AM
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */

import java.util.*;

public class LargestRectangularArea {
    private int calculateMaxArea(int[] input) {
        int maxArea = 0;
        int area = 0;
        int i;
        Stack<Integer> stack = new Stack<Integer>();
        int size = input.length;
        for (i = 0; i < size; ) {
            if ((stack.isEmpty()) || (input[stack.peek()] <= input[i])) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = input[top] * i;
                } else {
                    area = input[top] * (i - stack.peek() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                area = input[top] * i;
            } else {
                area = input[top] * (i - stack.peek() - 1);
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangularArea largestRectangularArea = new LargestRectangularArea();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            int maxArea = largestRectangularArea.calculateMaxArea(arr);
            System.out.println("The max area is: " + maxArea);
        }
    }
}
