package com.geeksforgeeks.datastructures.linkedlist.deletenodes;

/**
 * Created by Abhijeet on 25/09/16.
 * http://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
 */

import java.util.*;

public class DeleteNodes {
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

    private void reverseLinkedList() {
        if (head == null) {
            return;
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
    }

    private void deleteNodes() {
        Node max = head;
        Node temp = null;
        Node curr = head;
        while ((curr != null) && (curr.next != null)) {
            if (curr.next.data < max.data) {
                temp = curr.next;
                curr.next = temp.next;
                temp = null;
            } else {
                curr = curr.next;
                max = curr;
            }
        }
    }

    public static void main(String[] args) {
        DeleteNodes dn = new DeleteNodes();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            dn.push(sc.nextInt());
        }
        dn.reverseLinkedList();
        dn.deleteNodes();
        dn.reverseLinkedList();
        dn.printList();
    }
}
