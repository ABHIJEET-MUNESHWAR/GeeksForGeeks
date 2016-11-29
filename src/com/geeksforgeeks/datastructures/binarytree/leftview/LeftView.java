package com.geeksforgeeks.datastructures.binarytree.leftview;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 22/11/16
 * Time: 7:53 AM
 * http://www.geeksforgeeks.org/print-left-view-binary-tree/
 */
// Java program to print left view of binary tree

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

public class LeftView {
    Node root;
    int maxLevel = 0;

    private void leftView(Node node, int level) {
        if (node == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.println(node.data);
            maxLevel = level;
        }
        leftView(node.left, level + 1);
        leftView(node.right, level + 1);
    }

    /* testing for example nodes */
    public static void main(String args[]) {
        /*
          12
       /     \
     10       30
            /    \
          25      40
         */
        LeftView tree = new LeftView();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);

        tree.leftView(tree.root, 1);
    }
}
