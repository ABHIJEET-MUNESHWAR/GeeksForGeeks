package com.geeksforgeeks.datastructures.linkedlist.deletenodesgreaterthanx;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 05/03/17
 * Time: 1:20 AM
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


    private void deleteNodes(int x) {
        while (head.data > x) {
            head = head.next;
        }
        Node curr = head;
        Node prev = head;
        while (curr != null) {
            if (curr.data > x) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        DeleteNodes dn = new DeleteNodes();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            dn.push(sc.nextInt());
        }
        int x = sc.nextInt();
        dn.deleteNodes(x);
        dn.printList();
    }
}
