package com.geeksforgeeks.datastructures.binarytree.sumleftleaves;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 03/12/16
 * Time: 11:38 PM
 */
// Java program to find sum of all left leaves
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

    private int leftLeavesSum(Node node) {
        int sum = 0;
        if (node != null) {
            if (isLeaf(node.left)) {
                sum += node.left.data;
            } else {
                sum += leftLeavesSum(node.left);
            }
            sum += leftLeavesSum(node.right);
        }
        return sum;
    }

    private boolean isLeaf(Node node) {
        if (node == null) {
            return false;
        }
        if ((node.left == null) && (node.right == null)) {
            return true;
        }
        return false;
    }

    // Driver program
    public static void main(String args[]) {
/* Create following Binary Tree
          20
        /   \
       9     49
      / \    / \
     5   12 23  52
           \    /
            15 50
        */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(9);
        tree.root.right = new Node(49);
        tree.root.left.right = new Node(12);
        tree.root.left.left = new Node(5);
        tree.root.right.left = new Node(23);
        tree.root.right.right = new Node(52);
        tree.root.left.right.right = new Node(12);
        tree.root.right.right.left = new Node(50);

        System.out.println("The sum of leaves is " +
                tree.leftLeavesSum(tree.root));
    }
}
