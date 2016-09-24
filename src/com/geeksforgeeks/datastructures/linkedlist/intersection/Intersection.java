package com.geeksforgeeks.datastructures.linkedlist.intersection;

/**
 * Created by Abhijeet on 24/09/16.
 */

import java.util.*;

public class Intersection {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
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

    private Node intersection(Node head1, Node head2, Node head3) {
        if ((head1 == null) || (head2 == null)) {
            return head3;
        }
        Node curr1 = head1;
        Node curr2 = head2;
        while ((curr1 != null) && (curr2 != null)) {
            if (curr1.data > curr2.data) {
                curr2 = curr2.next;
            } else if (curr1.data < curr2.data) {
                curr1 = curr1.next;
            } else {
                push(curr1.data);
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }
        return head3;
    }

    public static void main(String[] args) {
        Intersection list1 = new Intersection();
        Intersection list2 = new Intersection();
        Intersection list3 = new Intersection();
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        for (int i = 0; i < size1; i++) {
            list1.push(sc.nextInt());
        }
        int size2 = sc.nextInt();
        for (int i = 0; i < size2; i++) {
            list2.push(sc.nextInt());
        }
        list3.intersection(list1.head, list2.head, list3.head);
        list3.printList(list3.head);
    }
}
