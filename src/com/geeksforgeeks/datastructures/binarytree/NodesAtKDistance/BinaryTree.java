package com.geeksforgeeks.datastructures.binarytree.NodesAtKDistance;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 30/11/16
 * Time: 8:48 AM
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

public class BinaryTree {
    Node root;

    private int printKDistanceNode(Node node, Node target, int k) {
        if (node == null) {
            return -1;
        }
        if (node == target) {
            printKDistanceNodeDown(node, k);
            return 0;
        }
        int dl = printKDistanceNode(node.left, target, k);
        if (dl != -1) {
            if (dl + 1 == k) {
                System.out.println(node.data);
            } else {
                printKDistanceNode(node.right, target, k - dl - 2);
            }
            return (1 + dl);
        }
        int dr = printKDistanceNode(node.right, target, k);
        if (dr != -1) {
            if (dr + 1 == k) {
                System.out.println(node.data);
            } else {
                printKDistanceNode(node.left, target, k - dr - 2);
            }
            return (1 + dr);
        }
        return -1;
    }

    private void printKDistanceNodeDown(Node node, int k) {
        if ((node == null) || (k < 0)) {
            return;
        }
        if (k == 0) {
            System.out.println(node.data);
            return;
        }
        printKDistanceNodeDown(node.left, k - 1);
        printKDistanceNodeDown(node.right, k - 1);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        Node target = tree.root.left.right;
        tree.printKDistanceNode(tree.root, target, 2);
    }
}
