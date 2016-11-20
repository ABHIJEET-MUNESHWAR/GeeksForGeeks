package com.geeksforgeeks.datastructures.binarytree.printlevelorder;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 13/11/16
 * Time: 8:04 PM
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

public class PrintLevelOrder {
    Node root;

    private void levelOrderTraversal() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0) {
                break;
            }
            while (nodeCount > 0) {
                Node node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                nodeCount--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PrintLevelOrder tree = new PrintLevelOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Level order traversal of binary tree is - ");
        tree.levelOrderTraversal();
    }
}

