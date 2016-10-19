package com.geeksforgeeks.datastructures.linkedlist.linkedlistlinesegment;

/**
 * Created by Abhijeet on 15/10/16.
 * http://www.geeksforgeeks.org/given-linked-list-line-segments-remove-middle-points/
 */

import java.util.*;

public class LineSegment {
    Node head;

    class Node {
        int x, y;
        Node next;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.next = null;
        }
    }

    private void push(int x, int y) {
        Node node = new Node(x, y);
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
            System.out.print("(" + curr.x + ", " + curr.y + ")");
            curr = curr.next;
        }
        System.out.println();
    }

    private void deleteMiddle() {
        if (head == null) {
            return;
        }
        Node curr = head;
        while ((curr != null) && (curr.next != null) && (curr.next.next != null)) {
            if (((curr.x == curr.next.x) && (curr.next.x == curr.next.next.x)) || ((curr.y == curr.next.y) && (curr.next.y == curr.next.next.y))) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        LineSegment lineSegment = new LineSegment();
        for (int i = 0; i < size; i++) {
            lineSegment.push(sc.nextInt(), sc.nextInt());
        }
        lineSegment.deleteMiddle();
        lineSegment.printList();
    }
}
