package com.geeksforgeeks.datastructures.binarytree.bttodll;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 12/02/17
 * Time: 3:00 PM
 * http://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
 */
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTreeToDll {
    Node root;
    Node head;
    static Node prev = null;

    private void printList(Node node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.right;
        }
    }

    private void binaryTree2DoubleLinkedList(Node root) {
        if (root == null) {
            return;
        }
        binaryTree2DoubleLinkedList(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        binaryTree2DoubleLinkedList(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeToDll tree = new BinaryTreeToDll();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // convert to DLL
        tree.binaryTree2DoubleLinkedList(tree.root);

        // Print the converted List
        tree.printList(tree.head);
    }

}
