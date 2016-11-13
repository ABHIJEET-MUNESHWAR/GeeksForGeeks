package com.geeksforgeeks.datastructures.queue.maximumofsubarray;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 11/11/16
 * Time: 7:55 AM
 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
 */

import java.util.*;

public class MaximumOfSubArray {
    private void printKMax(int[] input, int k) {
        int len = input.length;
        int i;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (i = 0; i < k; i++) {
            while ((!deque.isEmpty()) && (input[i] >= deque.peekLast())) {
                deque.removeLast();
            }
            deque.addLast(input[i]);
        }
        for (; i < len; i++) {
            System.out.println(deque.peekFirst());
            while ((!deque.isEmpty()) && (deque.peekFirst() <= i - k)) {
                deque.removeFirst();
            }
            while ((!deque.isEmpty()) && (input[i] >= input[deque.peekLast()])) {
                deque.removeLast();
            }
        }
        System.out.println(deque.peekFirst());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaximumOfSubArray maximumOfSubArray = new MaximumOfSubArray();
        int k = sc.nextInt();
        int size = sc.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = sc.nextInt();
        }
        maximumOfSubArray.printKMax(input, k);
    }
}
