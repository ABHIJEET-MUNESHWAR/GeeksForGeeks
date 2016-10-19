package com.geeksforgeeks.datastructures.linkedlist.absolutelistsorting;

/**
 * Created by Abhijeet on 16/10/16.
 * http://www.geeksforgeeks.org/sort-linked-list-already-sorted-absolute-values/
 */

import java.util.*;

public class SortLinkedList {
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

    private void sortLinkedList() {
        if (head == null) {
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.data < prev.data) {
                prev.next = curr.next;
                curr.next = head;
                head = curr;
                curr = prev;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        SortLinkedList sortLinkedList = new SortLinkedList();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            sortLinkedList.push(sc.nextInt());
        }
        sortLinkedList.sortLinkedList();
        sortLinkedList.printList();
    }
}
