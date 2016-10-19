package com.geeksforgeeks.datastructures.linkedlist.zigzag;

/**
 * Created by Abhijeet on 16/10/16.
 */

import java.util.*;

public class ZigZag {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private void push(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
    }

    private void printList() {
        if (head == null) {
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private void swap(Node a, Node b) {
        int t = a.data;
        a.data = b.data;
        b.data = t;
    }

    private void zigZagLinkedList() {
        if (head == null) {
            return;
        }
        Node curr = head;
        int count = 0;
        while (curr.next != null) {
            if (count % 2 == 0) {
                //check if curr < curr.next
                if (curr.data > curr.next.data) {
                    swap(curr, curr.next);
                }
            } else {
                //check if curr > curr.next
                if (curr.data < curr.next.data) {
                    swap(curr, curr.next);
                }
            }
            count++;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        ZigZag zz = new ZigZag();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            zz.push(sc.nextInt());
        }
        zz.zigZagLinkedList();
        System.out.println("Linked list after ordering in zigzag fashion:");
        zz.printList();
    }
}
