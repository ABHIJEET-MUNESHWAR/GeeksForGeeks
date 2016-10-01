package com.geeksforgeeks.datastructures.linkedlist.detectandremoveloop;

/**
 * Created by Abhijeet on 01/10/16.
 */

import java.util.*;

public class DetectAndRemoveLoop {
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

    private void detectAndRemoveLoop() {
        Node slowNode = head;
        Node fastNode = slowNode.next;
        while ((fastNode != null) && (fastNode.next != null)) {
            if (slowNode == fastNode) {
                break;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        if(slowNode == fastNode) {
            slowNode = head;
            while (slowNode != fastNode.next) {
                slowNode = slowNode.next;
                fastNode = fastNode.next;
            }
            fastNode.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DetectAndRemoveLoop darl = new DetectAndRemoveLoop();
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            darl.push(sc.nextInt());
        }
        darl.head.next.next.next.next = darl.head.next.next;
        darl.detectAndRemoveLoop();
        darl.printList();
    }
}
