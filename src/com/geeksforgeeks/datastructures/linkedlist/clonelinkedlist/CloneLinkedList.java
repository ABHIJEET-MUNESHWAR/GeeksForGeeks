package com.geeksforgeeks.datastructures.linkedlist.clonelinkedlist;

/**
 * Created by Abhijeet on 16/10/16.
 */

import java.util.*;

public class CloneLinkedList {
    Node head;

    class Node {
        int data;
        Node next;
        Node random;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
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
            System.out.println(curr.data + " " + curr.random.data);
            curr = curr.next;
        }
    }

    private void insertNodes(CloneLinkedList originalList,CloneLinkedList cloneLinkedList) {
        Node originalHead = originalList.head;
        Node originalCurr = originalHead;
        while(originalCurr!=null) {
            cloneLinkedList.push(originalCurr.data);
            originalCurr = originalCurr.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CloneLinkedList originalList = new CloneLinkedList();
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            originalList.push(sc.nextInt());
        }
        originalList.head.random = originalList.head.next.next.next;
        originalList.head.next.random = originalList.head;
        originalList.head.next.next.random = originalList.head.next.next.next.next;
        originalList.head.next.next.next.random = originalList.head.next;
        originalList.head.next.next.next.next.random = originalList.head.next;
        originalList.printList();
        CloneLinkedList cloneLinkedList = new CloneLinkedList();
        cloneLinkedList.insertNodes(originalList, cloneLinkedList);
    }
}
