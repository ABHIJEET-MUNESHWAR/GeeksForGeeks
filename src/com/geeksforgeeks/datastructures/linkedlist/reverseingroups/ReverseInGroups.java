package com.geeksforgeeks.datastructures.linkedlist.reverseingroups;

/**
 * Created by Abhijeet on 24/09/16.
 */

import java.util.*;

public class ReverseInGroups {
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

    public Node reverseInGroups(Node head, int k) {
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
        if (next != null) {
            head.next = reverseInGroups(next, k);
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReverseInGroups rig = new ReverseInGroups();
        int size = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < size; i++) {
            rig.push(sc.nextInt());
        }
        rig.head = rig.reverseInGroups(rig.head, k);
        rig.printList();
    }
}
