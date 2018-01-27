package com.geeksforgeeks.datastructures.linkedlist.mergelinkedilst;

/**
 * Created by Abhijeet on 14/10/16.
 * http://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/
 */

import java.util.*;

public class MergeLinkedList {
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

    private void MergeLinkedList(MergeLinkedList q) {
        Node pCurr = head;
        Node qCurr = q.head;
        Node pNext, qNext;
        while((pCurr!=null)&&(qCurr!=null)) {
            pNext = pCurr.next;
            qNext = qCurr.next;

            qCurr.next = pNext;
            pCurr.next = qCurr;

            pCurr = pNext;
            qCurr = qNext;
        }
        q.head = qCurr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeLinkedList list1 = new MergeLinkedList();
        MergeLinkedList list2 = new MergeLinkedList();
        int size1 = sc.nextInt();
        for (int i = 0; i < size1; i++) {
            list1.push(sc.nextInt());
        }
        int size2 = sc.nextInt();
        for (int i = 0; i < size2; i++) {
            list2.push(sc.nextInt());
        }
        list1.MergeLinkedList(list2);
        System.out.println("Linked list after merging is:");
        list1.printList();
        list2.printList();
    }
}
/*
public class LinkedList {

  Node head;
  int p=1;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    LinkedList list1 = new LinkedList();
    LinkedList list2 = new LinkedList();
    LinkedList list3 = new LinkedList();
    int size1 = sc.nextInt();
    for (int i = 0; i < size1; i++) {
      list1.push(sc.nextInt());
    }
    int size2 = sc.nextInt();
    for (int i = 0; i < size2; i++) {
      list2.push(sc.nextInt());
    }
    list3.head = list3.mergeAlternate(list1.head, list2.head);
    System.out.println("Linked list after merging is:");
    list3.printList();
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

  private Node mergeAlternate(Node a, Node b) {
    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }
    Node result = null;
    if (p == 1) {
      p = 0;
      result = a;
      result.next = mergeAlternate(a.next, b);
    } else {
      p = 1;
      result = b;
      result.next = mergeAlternate(a, b.next);
    }
    return result;
  }

  class Node {

    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

}

 */