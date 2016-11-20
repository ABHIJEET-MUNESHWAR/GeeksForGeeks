package com.geeksforgeeks.datastructures.binarytree.leafnodes;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 15/11/16
 * Time: 8:02 AM
 * http://www.geeksforgeeks.org/write-a-c-program-to-get-count-of-leaf-nodes-in-a-binary-tree/
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

public class LeafNodes {
    Node root;

    private int leafNodes(Node root) {
        if (root == null) {
            return 0;
        }
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        return ((leafNodes(root.left)) + leafNodes(root.right));
    }

    public static void main(String[] args) {
        LeafNodes tree = new LeafNodes();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("The count of leaf node is: " + tree.leafNodes(tree.root));
    }
}
