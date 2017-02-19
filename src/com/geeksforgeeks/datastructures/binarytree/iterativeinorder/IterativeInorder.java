package com.geeksforgeeks.datastructures.binarytree.iterativeinorder;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 12/02/17
 * Time: 12:05 PM
 */
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class IterativeInorder {
    Node root;

    private void inorder() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.println(node.data);
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    public static void main(String[] args) {
        IterativeInorder tree = new IterativeInorder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
    }
}
