package com.geeksforgeeks.datastructures.queue.connectropes;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 13/11/16
 * Time: 5:02 PM
 * http://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 */

import java.util.*;

public class ConnectRopes {
    private int minCost(PriorityQueue<Integer> queue) {
        int cost = 0;
        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            cost += first + second;
            queue.add(first+second);
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConnectRopes connectRopes = new ConnectRopes();
        int size = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            queue.add(sc.nextInt());
        }
        System.out.println("Minimum cost of connecting ropes is: " + connectRopes.minCost(queue));
    }
}
