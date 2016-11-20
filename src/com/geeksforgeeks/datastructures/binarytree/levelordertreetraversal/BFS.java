package com.geeksforgeeks.datastructures.binarytree.levelordertreetraversal;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 13/11/16
 * Time: 7:43 PM
 * http://www.geeksforgeeks.org/level-order-tree-traversal/
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

public class BFS {
    Node root;

    private void levelOrderTraversal() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BFS tree = new BFS();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Level order traversal of binary tree is - ");
        tree.levelOrderTraversal();
    }
}
