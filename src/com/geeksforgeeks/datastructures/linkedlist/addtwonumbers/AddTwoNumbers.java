package com.geeksforgeeks.datastructures.linkedlist.addtwonumbers;

/**
 * Created by Abhijeet on 01/10/16.
 */

/**
 * Created by Abhijeet on 01/10/16.
 */import java.util.*;

public class AddTwoNumbers {
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

    private void add(Node head1, Node head2) {
        Node ptr1 = head1, ptr2 = head2;
        int sum = 0, carry = 0;
        while ((ptr1 != null) && (ptr2 != null)) {
            sum = ptr1.data + ptr2.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            push(sum);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        while (ptr1 != null) {
            sum = ptr1.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            push(sum);
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            sum = ptr2.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            push(sum);
            ptr2 = ptr2.next;
        }
        if (carry > 0) {
            push(carry);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddTwoNumbers list1 = new AddTwoNumbers();
        AddTwoNumbers list2 = new AddTwoNumbers();
        AddTwoNumbers list3 = new AddTwoNumbers();
        int size1 = sc.nextInt();
        int size2 = sc.nextInt();
        for (int i = 0; i < size1; i++) {
            list1.push(sc.nextInt());
        }
        for (int i = 0; i < size2; i++) {
            list2.push(sc.nextInt());
        }
        list3.add(list1.head, list2.head);
        list3.printList();
    }
}
