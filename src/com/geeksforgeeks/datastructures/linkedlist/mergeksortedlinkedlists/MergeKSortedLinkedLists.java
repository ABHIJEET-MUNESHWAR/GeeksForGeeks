package com.geeksforgeeks.datastructures.linkedlist.mergeksortedlinkedlists;

/**
 * Created by Abhijeet on 17/10/16.
 */

import java.util.*;

public class MergeKSortedLinkedLists {
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

    private void printList(Node head) {
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

    private Node sortedMerge(Node a, Node b) {
        Node result = null;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.data < b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        if (b.data < a.data) {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    private Node mergeKLists(MergeKSortedLinkedLists[] sortLinkedList, int last) {
        while (last != 0) {
            int i = 0, j = last;
            while (i < j) {
                sortLinkedList[i].head = sortedMerge(sortLinkedList[i].head, sortLinkedList[j].head);
                i++;
                j--;
                if (i >= j) {
                    last = j;
                }
            }
        }
        return sortLinkedList[0].head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            MergeKSortedLinkedLists[] sortLinkedList = new MergeKSortedLinkedLists[k];
            MergeKSortedLinkedLists merge = new MergeKSortedLinkedLists();
            for (int j = 0; j < k; j++) {
                int n = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    sortLinkedList[j].push(sc.nextInt());
                }
            }
            Node head = merge.mergeKLists(sortLinkedList, k - 1);
            merge.printList(head);
        }
    }
}
