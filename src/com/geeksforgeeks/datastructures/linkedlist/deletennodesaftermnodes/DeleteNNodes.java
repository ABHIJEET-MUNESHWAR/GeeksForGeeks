package com.geeksforgeeks.datastructures.linkedlist.deletennodesaftermnodes;

/**
 * Created by Abhijeet on 14/10/16.
 * https://www.geeksforgeeks.org/delete-n-nodes-after-m-nodes-of-a-linked-list/
 */

import java.util.Scanner;

public class DeleteNNodes {
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

    public void deleteNNodesAfterMNodes(int m, int n) {
        int mCounter = 0, nCounter = 0;
        Node curr = head;
        Node del;
        while (n-- > 0) {
            curr = curr.next;
        }
        Node temp = curr.next;
        while (m-- > 0) {
            del = temp;
            temp = temp.next;
            del = null;
        }
        curr.next = temp;
    }

    public static void main(String[] args) {
        DeleteNNodes rll = new DeleteNNodes();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 0; i < size; i++) {
            rll.push(sc.nextInt());
        }
        System.out.println("Linked list before deleting:");
        rll.printList();
        rll.deleteNNodesAfterMNodes(m, n);
        System.out.println("Linked list before deleting:");
        rll.printList();
    }
}
