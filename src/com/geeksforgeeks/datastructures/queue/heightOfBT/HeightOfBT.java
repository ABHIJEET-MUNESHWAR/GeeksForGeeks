package com.geeksforgeeks.datastructures.queue.heightOfBT;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 12/11/16
 * Time: 7:48 PM
 * http://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/
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

public class HeightOfBT {
    Node root;

    private int heightOfBT(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int height = 0;
        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0) {
                return height;
            }
            height++;
            while (nodeCount > 0) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                nodeCount--;
            }
        }
    }

    public static void main(String[] args) {
        HeightOfBT tree = new HeightOfBT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("The height of binary tree is: " + tree.heightOfBT(tree.root));
    }
}
