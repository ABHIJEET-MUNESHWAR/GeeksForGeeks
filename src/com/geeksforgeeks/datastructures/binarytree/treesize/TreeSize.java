package com.geeksforgeeks.datastructures.binarytree.treesize;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 13/11/16
 * Time: 8:44 PM
 * http://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
 * Size of checkifbst tree is the number of elements present in the tree.
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

public class TreeSize {
    Node root;

    private int treeSize(Node root) {
        if (root == null) {
            return 0;
        } else {
            return (treeSize(root.left) + 1 + treeSize(root.right));
        }
    }

    public static void main(String[] args) {
        TreeSize tree = new TreeSize();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("The tree size is: " + tree.treeSize(tree.root));
    }
}
