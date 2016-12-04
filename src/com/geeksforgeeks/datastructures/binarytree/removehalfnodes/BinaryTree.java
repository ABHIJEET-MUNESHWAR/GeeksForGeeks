package com.geeksforgeeks.datastructures.binarytree.removehalfnodes;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 03/12/16
 * Time: 11:23 PM
 * http://www.geeksforgeeks.org/given-a-binary-tree-how-do-you-remove-all-the-half-nodes/
 */
// Java program to remove half nodes
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    private void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }

    private Node removeHalfNodes(Node node) {
        if (node == null) {
            return null;
        }
        node.left = removeHalfNodes(node.left);
        node.right = removeHalfNodes(node.right);
        if ((node.left == null) && (node.right == null)) {
            return node;
        }
        if (node.left == null) {
            Node newRoot = node.right;
            return newRoot;
        }
        if (node.right == null) {
            Node newRoot = node.left;
            return newRoot;
        }
        return node;
    }

    // Driver program
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        Node NewRoot = null;
        tree.root = new Node(2);
        tree.root.left = new Node(7);
        tree.root.right = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(1);
        tree.root.left.right.right = new Node(11);
        tree.root.right.right = new Node(9);
        tree.root.right.right.left = new Node(4);

        System.out.println("the inorder traversal of tree is ");
        tree.printInorder(tree.root);

        NewRoot = tree.removeHalfNodes(tree.root);

        System.out.print("\nInorder traversal of the modified tree \n");
        tree.printInorder(NewRoot);
    }
}
