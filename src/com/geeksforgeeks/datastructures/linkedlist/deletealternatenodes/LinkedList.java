package com.geeksforgeeks.datastructures.linkedlist.deletealternatenodes;

/**
 * Created by Abhijeet on 24/09/16.
 * http://www.geeksforgeeks.org/delete-alternate-nodes-of-a-linked-list/
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

    private void deleteAlternateNodes() {
        if (head == null) {
            return;
        }
        Node prev = head;
        Node now = head.next;
        while ((prev != null) && (now != null)) {
            prev.next = now.next;
            now = null;
            prev = prev.next;
            if (prev != null) {
                now = prev.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            list.push(sc.nextInt());
        }
        System.out.println("Linked list before deleting alternate nodes:");
        list.printList();
        list.deleteAlternateNodes();
        System.out.println("Linked list after deleting alternate nodes:");
        list.printList();
    }
}
