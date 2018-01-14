package com.geeksforgeeks.datastructures.linkedlist.addtwolinkedlists;

import java.util.Scanner;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 08/03/17
 * Time: 10:33 PM
 * http://www.geeksforgeeks.org/sum-of-two-linked-lists/
 */
public class SumTwoLinkedLists {
    Node head;
    int carry = 0;

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
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    private int getSize(Node head) {
        int size = 0;
        Node curr = head;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    private Node addSameSize(Node head1, Node head2) {
        if (head1 == null) {
            return null;
        }
        int sum = 0;
        Node result = new Node(carry);
        result.next = addSameSize(head1.next, head2.next);
        sum = carry + head1.data + head2.data;
        carry = sum / 10;
        sum = sum % 10;
        result.data += sum;
        return result;
    }

    private Node pushToList(Node node, int data) {
        Node newNode = new Node(data);
        newNode.next = node;
        node = newNode;
        return node;
    }

    private Node addCarryToRemaining(Node head1, Node curr, int carry, Node head3) {
        int sum = 0;
        if (head1 != curr) {
            addCarryToRemaining(head1.next, curr, carry, head3);
            sum = head1.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            head3 = pushToList(head3, sum);
        }
        return head3;
    }

    private void sumTwoLinkedLists(Node head1, Node head2) {
        int size1 = getSize(head1);
        int size2 = getSize(head2);
        Node curr;
        if (head1 == null) {
            head = head2;
            return;
        }
        if (head2 == null) {
            head = head1;
            return;
        }
        if (size1 == size2) {
            head = addSameSize(head1, head2);
        } else {
            int diff = Math.abs(size1 - size2);
            if (size1 < size2) {
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }
            curr = head1;
            while (diff-- > 0) {
                curr = curr.next;
            }
            head = addSameSize(curr, head2);
            head = addCarryToRemaining(head1, curr, carry, head);
        }
        if (carry != 0) {
            head = pushToList(head, carry);
        }
    }

    public static void main(String[] args) {
        SumTwoLinkedLists LinkedList1 = new SumTwoLinkedLists();
        SumTwoLinkedLists LinkedList2 = new SumTwoLinkedLists();
        SumTwoLinkedLists LinkedList3 = new SumTwoLinkedLists();
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        for (int i = 0; i < size1; i++) {
            LinkedList1.push(sc.nextInt());
        }
        int size2 = sc.nextInt();
        for (int i = 0; i < size2; i++) {
            LinkedList2.push(sc.nextInt());
        }
        LinkedList3.sumTwoLinkedLists(LinkedList1.head, LinkedList2.head);
        LinkedList3.printList();
    }

}
