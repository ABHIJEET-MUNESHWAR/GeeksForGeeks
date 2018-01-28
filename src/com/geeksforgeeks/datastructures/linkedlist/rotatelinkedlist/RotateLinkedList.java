package com.geeksforgeeks.datastructures.linkedlist.rotatelinkedlist;

/**
 * Created by Abhijeet on 04/10/16.
 * http://www.geeksforgeeks.org/rotate-a-linked-list/
 * Input: 10->20->30->40->50->60
 * Output: 50->60->10->20->30->40
 */

import java.util.*;

public class RotateLinkedList {
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

    public void rotateLinkedList(){
        if(head == null) {
            return;
        }
        Node prevHead = head;
        Node curr = head;
        while(curr.next!=null) {
            curr = curr.next;
        }
        curr.next = head;
        curr = prevHead;
        int s = 2;
        while (s-->0) {
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;
    }
    public static void main(String[] args) {
        RotateLinkedList rll = new RotateLinkedList();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for(int i=0; i<size; i++) {
            rll.push(sc.nextInt());
        }
        System.out.println("Linked list before rotating:");
        rll.printList();
        rll.rotateLinkedList();
        System.out.println("Linked list after rotating:");
        rll.printList();
    }
}
