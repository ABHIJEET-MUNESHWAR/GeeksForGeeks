package com.geeksforgeeks.datastructures.linkedlist.reversealternakenodes;

/**
 * Created by Abhijeet on 25/09/16.
 * http://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
 */

import java.util.*;

public class ReverseAlternateNodes {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data) {
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

    public void printList() {
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

    public Node reverseAlternateNodes(Node head, int k) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        int counter = 0;
        while ((counter < k) && (curr != null)) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            counter++;
        }
        if (head != null) {
            head.next = curr;
        }
        counter = 0;
        while ((counter < k - 1) && curr != null) {
            curr = curr.next;
            counter++;
        }
        if (curr != null) {
            curr.next = reverseAlternateNodes(curr.next, k);
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseAlternateNodes ran = new ReverseAlternateNodes();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < size; i++) {
            ran.push(sc.nextInt());
        }
        ran.head = ran.reverseAlternateNodes(ran.head, k);
        ran.printList();
    }
}
