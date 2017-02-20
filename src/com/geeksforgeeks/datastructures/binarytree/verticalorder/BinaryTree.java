package com.geeksforgeeks.datastructures.binarytree.verticalorder;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 01/12/16
 * Time: 8:08 AM
 * http://www.geeksforgeeks.org/print-binary-tree-vertical-order/
 */

import java.util.HashMap;

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

    private void verticalOrder(Node node) {
        if (node == null) {
            return;
        }
        HashMap<Integer, String> hashMap = new HashMap<>();
        verticalOrderUtil(node, 0, hashMap);
        if (!hashMap.isEmpty()) {
            System.out.println(hashMap.entrySet());
        }
    }

    private void verticalOrderUtil(Node node, int distance, HashMap<Integer, String> hashMap) {
        if (node == null) {
            return;
        }
        verticalOrderUtil(node.left, distance - 1, hashMap);
        String lastNumber = hashMap.get(distance) == null ? "" : hashMap.get(distance);
        hashMap.put(distance, lastNumber + " " + node.data);
        verticalOrderUtil(node.right, distance + 1, hashMap);
    }

    public static void main(String[] args) {
        /* Create following Binary Tree
           1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9

        */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);


        System.out.println("vertical order traversal is :");
        tree.verticalOrder(tree.root);
    }
}
