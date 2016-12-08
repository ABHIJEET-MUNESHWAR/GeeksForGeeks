package com.geeksforgeeks.datastructures.binarysearchtree.lca;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/12/16
 * Time: 5:23 PM
 * http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 */
// A binary tree node
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

    private Node lca(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }
        if ((node.data > n1) && (node.data > n2)) {
            return lca(node.left, n1, n2);
        }
        if ((node.data < n1) && (node.data < n2)) {
            return lca(node.right, n1, n2);
        }
        return node;
    }

    /* Driver program to test lca() */
    public static void main(String args[]) {
        // Let us construct the BST shown in the above figure
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        Node t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

    }
}
