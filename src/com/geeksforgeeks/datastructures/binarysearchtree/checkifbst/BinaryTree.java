package com.geeksforgeeks.datastructures.binarysearchtree.checkifbst;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/12/16
 * Time: 5:13 PM
 */
/* Class containing left and right child of current
 node and key value*/
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    private boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if ((node.data < min) || (node.data > max)) {
            return false;
        }
        return ((isBSTUtil(node.left, min, node.data - 1)) && (isBSTUtil(node.right, node.data, max)));
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
