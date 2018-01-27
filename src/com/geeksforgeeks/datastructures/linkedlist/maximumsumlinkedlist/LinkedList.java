package com.geeksforgeeks.datastructures.linkedlist.maximumsumlinkedlist;

/**
 * Created by Abhijeet on 16/10/16.
 * https://www.geeksforgeeks.org/maximum-sum-linked-list-two-sorted-linked-lists-common-nodes/
 */
public class LinkedList {

  Node head;  // head of list

  /* Drier program to test above functions */
  public static void main(String args[]) {
    LinkedList llist1 = new LinkedList();
    LinkedList llist2 = new LinkedList();

    //Linked List 1 : 1->3->30->90->110->120->NULL
    //Linked List 2 : 0->3->12->32->90->100->120->130->NULL

    llist1.push(120);
    llist1.push(110);
    llist1.push(90);
    llist1.push(30);
    llist1.push(3);
    llist1.push(1);

    llist2.push(130);
    llist2.push(120);
    llist2.push(100);
    llist2.push(90);
    llist2.push(32);
    llist2.push(12);
    llist2.push(3);
    llist2.push(0);

    llist1.finalMaxSumList(llist1.head, llist2.head);
  }

  private void finalMaxSumList(Node a, Node b) {
    Node result = null;
    Node curr1 = a, prev1 = a;
    Node curr2 = b, prev2 = b;
    while (curr1 != null || curr2 != null) {
      int sum1 = 0, sum2 = 0;
      while ((curr1 != null) && (curr2 != null) && (curr1.data != curr2.data)) {
        if (curr1.data < curr2.data) {
          sum1 += curr1.data;
          curr1 = curr1.next;
        } else {
          sum2 += curr2.data;
          curr2 = curr2.next;
        }
      }
      if (curr1 == null) {
        while (curr2 != null) {
          sum2 += curr2.data;
          curr2 = curr2.next;
        }
      }
      if (curr2 == null) {
        while (curr1 != null) {
          sum1 += curr1.data;
          curr1 = curr1.next;
        }
      }
      if ((prev1 == a) && (prev2 == b)) {
        result = (sum1 > sum2) ? prev1 : prev2;
      } else {
        if (sum1 > sum2) {
          prev2.next = prev1.next;
        } else {
          prev1.next = prev2.next;
        }
      }
      prev1 = curr1;
      prev2 = curr2;
      if (curr1 != null) {
        curr1 = curr1.next;
      }
      if (curr2 != null) {
        curr2 = curr2.next;
      }
    }
    while (result != null) {
      System.out.print(result.data + " --> ");
      result = result.next;
    }
    System.out.println();
  }

  /*  Inserts a node at start of linked list */
  void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
    Node new_node = new Node(new_data);

    /* 3. Make next of new Node as head */
    new_node.next = head;

    /* 4. Move the head to point to new Node */
    head = new_node;
  }

  /* Linked list Node*/
  class Node {

    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }
}
