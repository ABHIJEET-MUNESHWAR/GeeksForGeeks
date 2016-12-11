package com.geeksforgeeks.datastructures.heap.connectnropes;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 08/12/16
 * Time: 10:56 PM
 */

import java.util.*;

public class ConnectNRopes {
    private int minCost(int size, int[] input) {
        int minCost = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            queue.add(input[i]);
        }
        while (queue.size() > 1) {
            int first = queue.remove();
            int second = queue.remove();
            int sum = first + second;
            minCost += sum;
            queue.add(sum);
        }
        return minCost;
    }

    public static void main(String[] args) {
        ConnectNRopes connectNRopes = new ConnectNRopes();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = sc.nextInt();
        }
        int minCost = connectNRopes.minCost(size, input);
        System.out.println("Minimum cost of connecting ropes is: " + minCost);
    }
}
