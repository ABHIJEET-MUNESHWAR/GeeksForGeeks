package com.geeksforgeeks.datastructures.linkedlist.decimalequivalentofbinary;

/**
 * Created by Abhijeet on 19/10/16.
 * http://www.geeksforgeeks.org/decimal-equivalent-of-binary-linked-list/
 */

import java.util.*;
public class LinkedList {
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

    private int binaryToDecimal(){
        int sum =0;
        Node curr = head;
        while(curr!=null) {
            sum = sum * 2 + curr.data;
            curr = curr.next;
        }
        return sum;
    }
    public static void main(String[] args) {
        LinkedList zz = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            zz.push(sc.nextInt());
        }
        int num = zz.binaryToDecimal();
        System.out.println(num);
    }
}
