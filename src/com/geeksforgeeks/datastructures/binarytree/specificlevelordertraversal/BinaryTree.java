package com.geeksforgeeks.datastructures.binarytree.specificlevelordertraversal;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 03/12/16
 * Time: 10:02 PM
 * http://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal/
 */
// Java program for special level order traversal

import java.util.LinkedList;
import java.util.Queue;

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

    private void printSpecificLevelOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        if ((node.left != null) && (node.right != null)) {
            System.out.println(node.left.data);
            System.out.println(node.right.data);
        }
        if (node.left.left == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node.left);
        queue.add(node.right);
        Node first = null;
        Node second = null;
        while (!queue.isEmpty()) {
            first = queue.poll();
            second = queue.poll();
            System.out.println(first.left.data);
            System.out.println(second.right.data);
            System.out.println(first.right.data);
            System.out.println(second.left.data);
            if (first.left.left != null) {
                queue.add(first.left);
                queue.add(second.right);
                queue.add(first.right);
                queue.add(second.left);
            }
        }
    }

    // Driver program to test for above functions
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(11);
        tree.root.right.left.left = new Node(12);
        tree.root.right.left.right = new Node(13);
        tree.root.right.right.left = new Node(14);
        tree.root.right.right.right = new Node(15);

        tree.root.left.left.left.left = new Node(16);
        tree.root.left.left.left.right = new Node(17);
        tree.root.left.left.right.left = new Node(18);
        tree.root.left.left.right.right = new Node(19);
        tree.root.left.right.left.left = new Node(20);
        tree.root.left.right.left.right = new Node(21);
        tree.root.left.right.right.left = new Node(22);
        tree.root.left.right.right.right = new Node(23);
        tree.root.right.left.left.left = new Node(24);
        tree.root.right.left.left.right = new Node(25);
        tree.root.right.left.right.left = new Node(26);
        tree.root.right.left.right.right = new Node(27);
        tree.root.right.right.left.left = new Node(28);
        tree.root.right.right.left.right = new Node(29);
        tree.root.right.right.right.left = new Node(30);
        tree.root.right.right.right.right = new Node(31);

        System.out.println("Specific Level Order traversal of binary tree is ");
        tree.printSpecificLevelOrder(tree.root);
    }
}
