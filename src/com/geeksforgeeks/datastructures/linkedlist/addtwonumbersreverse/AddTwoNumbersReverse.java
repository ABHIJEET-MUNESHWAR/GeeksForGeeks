package com.geeksforgeeks.datastructures.linkedlist.addtwonumbersreverse;

/**
 * Created by Abhijeet on 01/10/16.
 */

import java.util.*;

public class AddTwoNumbersReverse {
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

    private void add(Node head1, Node head2) {
        //
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddTwoNumbersReverse list1 = new AddTwoNumbersReverse();
        AddTwoNumbersReverse list2 = new AddTwoNumbersReverse();
        AddTwoNumbersReverse addition = new AddTwoNumbersReverse();
        int size1 = sc.nextInt();
        int size2 = sc.nextInt();
        for (int i = 0; i < size1; i++) {
            list1.push(sc.nextInt());
        }
        for (int i = 0; i < size2; i++) {
            list2.push(sc.nextInt());
        }
        addition.add(list1.head, list2.head);
        addition.printList();
    }
}
