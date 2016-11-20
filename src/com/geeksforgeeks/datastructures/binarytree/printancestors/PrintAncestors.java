package com.geeksforgeeks.datastructures.binarytree.printancestors;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 20/11/16
 * Time: 1:52 PM
 * http://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
 */
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class PrintAncestors {
    Node root;

    private boolean printAncestors(Node node, int target) {
        if (node == null) {
            return false;
        }
        if (node.data == target) {
            return true;
        }
        if ((printAncestors(node.left, target)) || (printAncestors(node.right, target))) {
            System.out.println(node.data);
            return true;
        }
        return false;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        PrintAncestors tree = new PrintAncestors();

        /* Construct the following binary tree
                  1
                /   \
               2     3
              /  \
             4    5
            /
           7
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);

        tree.printAncestors(tree.root, 7);

    }
}
