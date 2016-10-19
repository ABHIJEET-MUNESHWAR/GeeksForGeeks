package com.geeksforgeeks.datastructures.linkedlist.multiply;

/**
 * Created by Abhijeet on 17/10/16.
 */

import java.util.*;

public class MultiplyLinkedList {
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

    private int getNumber() {
        if (head == null) {
            return 0;
        }
        Node curr = head;
        int mul = 1;
        int sum = 0;
        while (curr != null) {
            sum = sum + (curr.data % 10);
            sum = sum * 10;
            curr = curr.next;
        }
        sum = sum / 10;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int mod = 1000 * 1000 * 1000 + 7;
        while (t-- > 0) {
            MultiplyLinkedList list1 = new MultiplyLinkedList();
            MultiplyLinkedList list2 = new MultiplyLinkedList();
            int size1 = sc.nextInt();
            for (int i = 0; i < size1; i++) {
                list1.push(sc.nextInt());
            }
            int size2 = sc.nextInt();
            for (int i = 0; i < size2; i++) {
                list2.push(sc.nextInt());
            }
            int n1 = list1.getNumber();
            int n2 = list2.getNumber();
            int sum = n1 * n2;
            sum = sum % mod;
            System.out.println(sum);
        }
    }
}
