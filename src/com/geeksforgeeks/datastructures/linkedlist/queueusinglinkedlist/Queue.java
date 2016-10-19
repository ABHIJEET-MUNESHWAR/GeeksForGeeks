package com.geeksforgeeks.datastructures.linkedlist.queueusinglinkedlist;

/**
 * Created by Abhijeet on 18/10/16.
 */

import java.util.*;

public class Queue {
    Node front, rear;
    int length;

    Queue() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private boolean isEmpty() {
        return (length == 0);
    }

    private void enqueue(int data) {
        Node node = new Node(data);
        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        length++;
    }

    private void dequeue() {
        if (!isEmpty()) {
            front = front.next;
            length--;
        }
    }

    private void printQueue() {
        Node curr = front;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
    }
}
