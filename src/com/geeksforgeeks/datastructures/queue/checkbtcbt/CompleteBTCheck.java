package com.geeksforgeeks.datastructures.queue.checkbtcbt;

import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 10/11/16
 * Time: 9:22 PM
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
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

public class CompleteBTCheck {
    Node root;

    private boolean isCompleteBT(Node root) {
        if (root == null) {
            return true;
        }
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        boolean flag = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp.left != null) {
                if (flag) {
                    return false;
                }
                queue.add(temp.left);
            } else {
                flag = true;
            }
            if (temp.right != null) {
                if (flag) {
                    return false;
                }
                queue.add(temp.right);
            } else {
                flag = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CompleteBTCheck completeBTCheck = new CompleteBTCheck();
        completeBTCheck.root = new Node(1);
        completeBTCheck.root.left = new Node(2);
        completeBTCheck.root.right = new Node(3);
        completeBTCheck.root.left.left = new Node(4);
        completeBTCheck.root.left.right = new Node(5);
        completeBTCheck.root.right.right = new Node(6);
        if (completeBTCheck.isCompleteBT(completeBTCheck.root)) {
            System.out.println("Complete Binary Tree");
        } else {
            System.out.println("Not Complete Binary Tree");
        }
    }
}
