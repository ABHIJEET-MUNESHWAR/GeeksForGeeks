package com.geeksforgeeks.datastructures.linkedlist.reverseiterative;

import java.util.Scanner;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/03/17
 * Time: 7:56 PM
 */
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class IterativeReverse {
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

    private Node reverse(Node curr, Node prev) {
        if (curr.next == null) {
            head = curr;
            curr.next = prev;
            return null;
        }
        Node next1 = curr.next;
        curr.next = prev;
        reverse(next1, curr);
        return head;
    }

    public static void main(String[] args) {
        IterativeReverse r = new IterativeReverse();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            r.push(sc.nextInt());
        }
        System.out.println("Linked list before reversing:");
        r.printList(head);
        head = r.reverse(head, null);
        System.out.println("Linked list after reversing:");
        r.printList(head);
    }
}