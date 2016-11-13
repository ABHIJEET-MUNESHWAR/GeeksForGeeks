package com.geeksforgeeks.datastructures.queue.introduction;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 10/11/16
 * Time: 9:00 PM
 */

import java.util.*;

public class Introduction {
    private void displayQueue(PriorityQueue<Integer> queue) {
        System.out.println("The queue elements are:");
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Introduction introduction = new Introduction();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        introduction.displayQueue(queue);
        System.out.println("Front: " + queue.peek());
        introduction.displayQueue(queue);
        System.out.println("Front: " + queue.element());
        introduction.displayQueue(queue);
        queue.remove();
        introduction.displayQueue(queue);
        queue.poll();
        introduction.displayQueue(queue);
    }
}
