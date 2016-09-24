package com.geeksforgeeks.datastructures.linkedlist.pairwiseswap;

/**
 * Created by Abhijeet on 24/09/16.
 * http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
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

public class PairWseSwap {
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

    private void pairWiseSwap(Node head) {
        Node temp = head;
        while ((temp != null) && (temp.next != null)) {
            int t = temp.data;
            temp.data = temp.next.data;
            temp.next.data = t;
            temp = temp.next.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PairWseSwap pws = new PairWseSwap();
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            pws.push(sc.nextInt());
        }
        System.out.println("Linked list before pairwise swap:");
        pws.printList(head);
        pws.pairWiseSwap(head);
        System.out.println("Linked list after pairwise swap:");
        pws.printList(head);
    }
}
