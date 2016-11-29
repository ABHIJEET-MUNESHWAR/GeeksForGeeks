package com.geeksforgeeks.datastructures.binarytree.LCA;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 24/11/16
 * Time: 8:33 AM
 */
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

    private int findLCA(int n1, int n2) {
        Node node = findLCAUtil(root, n1, n2);
        return node.data;
    }

    private Node findLCAUtil(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }
        if ((node.data == n1) || (node.data == n2)) {
            return node;
        }
        Node lcaLeft = findLCAUtil(node.left, n1, n2);
        Node lcaRight = findLCAUtil(node.right, n1, n2);
        if ((lcaLeft != null) && (lcaRight != null)) {
            return node;
        }
        return ((lcaLeft != null) ? lcaLeft : lcaRight);
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        /*
                                          1
                                      /      \
                                    2          3
                                  /   \       /  \
                                 4     5     6    7

         */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " +
                tree.findLCA(4, 5));
        System.out.println("LCA(4, 6) = " +
                tree.findLCA(4, 6));
        System.out.println("LCA(3, 4) = " +
                tree.findLCA(3, 4));
        System.out.println("LCA(2, 4) = " +
                tree.findLCA(2, 4));
    }
}
