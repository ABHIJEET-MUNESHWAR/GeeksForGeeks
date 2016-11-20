package com.geeksforgeeks.datastructures.binarytree.heightoftree;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 13/11/16
 * Time: 11:23 PM
 * http://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
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

public class TreeHeight {
    Node root;

    private int treeHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            int lDepth = treeHeight(root.left);
            int rDepth = treeHeight(root.right);
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }

    public static void main(String[] args) {
        TreeHeight tree = new TreeHeight();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("The tree size is: " + tree.treeHeight(tree.root));
    }
}
