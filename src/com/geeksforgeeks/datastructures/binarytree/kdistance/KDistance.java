package com.geeksforgeeks.datastructures.binarytree.kdistance;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 20/11/16
 * Time: 1:16 PM
 * http://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
 */
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class KDistance {
    Node root;

    private void printKDistant(Node node, int k) {
        if (node == null) {
            return;
        } else {
            if (k == 0) {
                System.out.println(node.data);
            } else {
                printKDistant(node.left, k - 1);
                printKDistant(node.right, k - 1);
            }
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        KDistance tree = new KDistance();

        /* Constructed binary tree is
                1
              /   \
             2     3
            /  \   /
           4    5 8
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(8);

        tree.printKDistant(tree.root, 2);
    }
}
