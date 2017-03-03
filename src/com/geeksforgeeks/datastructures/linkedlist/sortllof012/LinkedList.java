package com.geeksforgeeks.datastructures.linkedlist.sortllof012;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 03/03/17
 * Time: 9:39 PM
 * http://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/
 */
public class LinkedList {
    Node head;  // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void sortList() {
        if (head == null) {
            return;
        }
        int[] count = {0, 0, 0};
        Node curr = head;
        while (curr != null) {
            count[curr.data]++;
            curr = curr.next;
        }
        int i = 0;
        curr = head;
        while (curr != null) {
            if (count[i] == 0) {
                i++;
            } else {
                curr.data = i;
                count[i]--;
                curr = curr.next;
            }
        }
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        LinkedList llist = new LinkedList();

        /* Constructed Linked List is 1->2->3->4->5->6->7->
           8->8->9->null */
        llist.push(0);
        llist.push(1);
        llist.push(0);
        llist.push(2);
        llist.push(1);
        llist.push(1);
        llist.push(2);
        llist.push(1);
        llist.push(2);

        System.out.println("Linked List before sorting");
        llist.printList();

        llist.sortList();

        System.out.println("Linked List after sorting");
        llist.printList();
    }
}
