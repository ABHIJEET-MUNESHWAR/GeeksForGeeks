package com.geeksforgeeks.datastructures.binarytree.doubletree;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 19/11/16
 * Time: 7:59 PM
 * http://www.geeksforgeeks.org/double-tree/
 */
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class DoubleTree {
    Node root;

    private void doubleTree(Node node) {
        Node oldLeft;
        if (node == null) {
            return;
        }
        doubleTree(node.left);
        doubleTree(node.right);
        oldLeft = node.left;
        node.left = new Node(node.data);
        node.left.left = oldLeft;
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.println(node.data);
        printInOrder(node.right);
    }

    /* Driver program to test the above functions */
    public static void main(String args[]) {
        /* Constructed binary tree is
              1
            /   \
           2     3
         /  \
        4    5
        */
        DoubleTree tree = new DoubleTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Original tree is : ");
        tree.printInOrder(tree.root);
        tree.doubleTree(tree.root);
        System.out.println("");
        System.out.println("Inorder traversal of double tree is : ");
        tree.printInOrder(tree.root);
    }
}
