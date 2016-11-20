package com.geeksforgeeks.datastructures.linkedlist.binarytreetodll;

/**
 * Created by Abhijeet on 16/10/16.
 * http://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
 */

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Inorder {
    Node root;
    Node head;
    static Node prev = null;

    private void printList(Node head) {
        Node curr = head;
        System.out.println("Extracted Double Linked List is : ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    private void binaryTreeToDLL(Node root) {
        if (root == null) {
            return;
        }
        binaryTreeToDLL(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        binaryTreeToDLL(root.right);
    }

    public static void main(String[] args) {
        Inorder tree = new Inorder();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
        tree.binaryTreeToDLL(tree.root);
        tree.printList(tree.head);
    }
}