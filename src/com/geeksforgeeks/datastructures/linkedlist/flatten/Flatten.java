package com.geeksforgeeks.datastructures.linkedlist.flatten;

/**
 * Created by Abhijeet on 12/10/16.
 * http://www.geeksforgeeks.org/flattening-a-linked-list/
 */

import java.util.*;

public class Flatten {
    Node head;

    class Node {
        int data;
        Node right;
        Node down;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.down = null;
        }
    }

    public Node push(Node headRef, int data) {
        Node node = new Node(data);
        node.down = headRef;
        headRef = node;
        return headRef;
    }

    public void printList() {
        if (head == null) {
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.down;
        }
        System.out.println();
    }

    public Node merge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        Node result;
        if (a.data < b.data) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }
        return result;
    }

    public Node flatten(Node root) {
        if (root == null || root.right == null) {
            return root;
        }
        root.right = flatten(root.right);
        root = merge(root, root.right);
        return root;
    }

    public static void main(String[] args) {
        Flatten flatten = new Flatten();

        flatten.head = flatten.push(flatten.head, 30);
        flatten.head = flatten.push(flatten.head, 8);
        flatten.head = flatten.push(flatten.head, 7);
        flatten.head = flatten.push(flatten.head, 5);

        flatten.head.right = flatten.push(flatten.head.right, 20);
        flatten.head.right = flatten.push(flatten.head.right, 10);

        flatten.head.right.right = flatten.push(flatten.head.right.right, 50);
        flatten.head.right.right = flatten.push(flatten.head.right.right, 22);
        flatten.head.right.right = flatten.push(flatten.head.right.right, 19);

        flatten.head.right.right.right = flatten.push(flatten.head.right.right.right, 45);
        flatten.head.right.right.right = flatten.push(flatten.head.right.right.right, 40);
        flatten.head.right.right.right = flatten.push(flatten.head.right.right.right, 35);
        flatten.head.right.right.right = flatten.push(flatten.head.right.right.right, 28);
        flatten.head = flatten.flatten(flatten.head);
        flatten.printList();
    }
}
