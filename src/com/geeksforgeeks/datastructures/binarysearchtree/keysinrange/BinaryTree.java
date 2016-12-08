package com.geeksforgeeks.datastructures.binarysearchtree.keysinrange;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/12/16
 * Time: 5:48 PM
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

    private void print(Node node, int k1, int k2) {
        if (node == null) {
            return;
        }
        if (node.data > k1) {
            print(node.left, k1, k2);
        }
        if ((node.data >= k1) && (node.data <= k2)) {
            System.out.println(node.data);
        }
        if (node.data < k2) {
            print(node.right, k1, k2);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int k1 = 10, k2 = 25;
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);

        tree.print(tree.root, k1, k2);
    }
}
