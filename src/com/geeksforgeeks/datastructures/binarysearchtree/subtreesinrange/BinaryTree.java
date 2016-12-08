package com.geeksforgeeks.datastructures.binarysearchtree.subtreesinrange;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/12/16
 * Time: 7:24 PM
 * http://www.geeksforgeeks.org/count-bst-subtrees-that-lie-in-given-range/
 */
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

    private int getCount(Node node, int low, int high) {
        int count = 0;
        getCountUtil(node, low, high, count);
        return count;
    }

    private boolean getCountUtil(Node node, int low, int high, int count) {
        if (node == null) {
            return true;
        }
        boolean l = (node.left != null) ? getCountUtil(node.left, low, high, count) : true;
        boolean r = (node.right != null) ? getCountUtil(node.right, low, high, count) : true;
        if ((l) && (r) && (node.data >= low) && (node.data <= high)) {
            count++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /* Let us constructed BST shown in above example
                  10
                /    \
              5       50
             /       /  \
            1       40   100   */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(50);
        tree.root.left.left = new Node(1);
        tree.root.right.left = new Node(40);
        tree.root.right.right = new Node(100);
        int l = 5;
        int h = 45;
        int c = tree.getCount(tree.root, l, h);
        System.out.println(c);
    }
}
