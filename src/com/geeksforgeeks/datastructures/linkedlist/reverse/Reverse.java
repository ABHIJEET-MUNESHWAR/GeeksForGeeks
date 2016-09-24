package com.geeksforgeeks.datastructures.linkedlist.reverse;

/**
 * Created by Abhijeet on 23/09/16.
 */

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Reverse {
    static Node head;

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

    private void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private Node reverse(Node head) {
        if (head == null) {
            return head;
        }
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        Reverse r = new Reverse();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            r.push(sc.nextInt());
        }
        System.out.println("Linked list before reversing:");
        r.printList(head);
        head = r.reverse(head);
        System.out.println("Linked list after reversing:");
        r.printList(head);
    }
}
