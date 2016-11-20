package com.geeksforgeeks.datastructures.binarytree.convertbttocs;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 16/11/16
 * Time: 7:31 AM
 * http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/
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

public class BTToCS {
    Node root;

    private void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.println(node.data);
        printInorder(node.right);
    }

    private void convertTree(Node node) {
        int leftData = 0, rightData = 0, diff = 0;
        if ((node == null) || ((node.left == null) && (node.right == null))) {
            return;
        }
        convertTree(node.left);
        convertTree(node.right);
        if (node.left != null) {
            leftData = node.left.data;
        }
        if (node.right != null) {
            rightData = node.right.data;
        }
        diff = leftData + rightData - node.data;
        if (diff > 0) {
            node.data = node.data + diff;
        } else {
            increment(node, -diff);
        }
    }

    private void increment(Node node, int diff) {
        if (node.left != null) {
            node.left.data = node.left.data + diff;
            increment(node.left, diff);
        } else if (node.right != null) {
            node.right.data = node.right.data + diff;
            increment(node.right, diff);
        }
    }

    public static void main(String[] args) {
        BTToCS tree = new BTToCS();
        tree.root = new Node(50);
        tree.root.left = new Node(7);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(1);
        tree.root.right.right = new Node(30);
        System.out.println("InOrder traversal before conversion is :");
        tree.printInorder(tree.root);

        tree.convertTree(tree.root);
        System.out.println("");

        System.out.println("InOrder traversal after conversion is :");
        tree.printInorder(tree.root);
    }
}
