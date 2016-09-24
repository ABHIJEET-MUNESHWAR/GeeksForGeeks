package com.geeksforgeeks.datastructures.linkedlist.swapnodes;

/**
 * Created by abhijeet on 20/09/16.
 * http://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
 */

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class SwapNodes {
    Node head;

    private void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    private void printList() {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
    }

    private void swapNodes(int x, int y) {
        if (x == y) {
            return;
        }
        Node currX, currY, prevX = null, prevY = null;
        currX = head;
        currY = head;
        while ((currX != null) && (currX.data != x)) {
            prevX = currX;
            currX = currX.next;
        }
        while ((currY != null) && (currY.data != y)) {
            prevY = currY;
            currY = currY.next;
        }
        if ((currX == null) || (currY == null)) {
            return;
        }
        if (prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }
        if(prevY!=null) {
            prevY.next = currX;
        } else {
            head = currX;
        }
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SwapNodes sn = new SwapNodes();
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            sn.push(sc.nextInt());
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Linked list before swapping nodes:");
        sn.printList();
        sn.swapNodes(a, b);
        System.out.println("Linked list after swapping nodes:");
        sn.printList();
    }
}
