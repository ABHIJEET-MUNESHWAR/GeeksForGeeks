package com.geeksforgeeks.datastructures.binarytree.zigzag;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 15/11/16
 * Time: 8:09 AM
 * http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
 */

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class ZigZag {
    Node root;

    private void zigZagOrder(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(node);
        while ((!s1.isEmpty()) || (!s2.isEmpty())) {
            while (!s1.isEmpty()) {
                Node temp = s1.pop();
                System.out.println(temp.data);
                if (temp.right != null) {
                    s2.push(temp.right);
                }
                if (temp.left != null) {
                    s2.push(temp.left);
                }
            }
            while (!s2.isEmpty()) {
                Node temp = s2.pop();
                System.out.println(temp.data);
                if (temp.left != null) {
                    s1.push(temp.left);
                }
                if (temp.right != null) {
                    s1.push(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        ZigZag tree = new ZigZag();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("The count of leaf node is: ");
        tree.zigZagOrder(tree.root);
    }
}
