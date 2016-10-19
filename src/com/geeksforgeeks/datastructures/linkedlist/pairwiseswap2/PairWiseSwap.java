package com.geeksforgeeks.datastructures.linkedlist.pairwiseswap2;

/**
 * Created by Abhijeet on 14/10/16.
 */

import java.util.*;

public class PairWiseSwap {
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

    private void pairWiseSwap() {
        if ((head == null) || (head.next == null)) {
            return;
        }
        Node prev = head;
        Node curr = head.next;
        head = curr;
        while (true) {
            Node next = curr.next;
            curr.next = prev;
            if ((next == null) || (next.next == null)) {
                prev.next = next;
                break;
            }
            prev.next = next.next;
            prev = next;
            curr = prev.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PairWiseSwap pws = new PairWiseSwap();
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            pws.push(sc.nextInt());
        }
        System.out.println("Linked list before pairwise swap:");
        pws.printList();
        pws.pairWiseSwap();
        System.out.println("Linked list after pairwise swap:");
        pws.printList();
    }
}
