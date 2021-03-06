package com.geeksforgeeks.datastructures.linkedlist.alternatesplit;

/**
 * Created by Abhijeet on 24/09/16.
 * http://www.geeksforgeeks.org/alternating-split-of-a-given-singly-linked-list/
 */

import java.util.*;

public class LinkedList {
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

    private void alternateSplit(LinkedList list1, LinkedList list2) {
        if (this.head == null) {
            return;
        }
        Node curr = this.head;
        Node next = curr.next;
        while (next.next != null) {
            list1.push(curr.data);
            list2.push(next.data);
            curr = next.next;
            next = curr.next;
        }
        list1.push(curr.data);
        list2.push(next.data);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            list.push(sc.nextInt());
        }
        LinkedList a = new LinkedList();
        LinkedList b = new LinkedList();
        list.alternateSplit(a, b);
        a.printList();
        b.printList();
    }
}
