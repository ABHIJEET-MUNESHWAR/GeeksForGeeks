package com.geeksforgeeks.datastructures.binarytree.verticalsum;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 20/11/16
 * Time: 4:49 PM
 * http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
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

public class VerticalSum {
    Node root;

    private void verticalSumMain(Node node) {
        if (root == null) {
            return;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        verticalSumUtil(node, 0, hashMap);
        if (!hashMap.isEmpty()) {
            System.out.println(hashMap.entrySet());
        }
    }

    private void verticalSumUtil(Node node, int distance, HashMap<Integer, Integer> hashMap) {
        if (node == null) {
            return;
        }
        verticalSumUtil(node.left, distance - 1, hashMap);
        int lastSum = hashMap.get(distance) == null ? 0 : hashMap.get(distance);
        hashMap.put(distance, lastSum + node.data);
        verticalSumUtil(node.right, distance + 1, hashMap);
    }

    public static void main(String[] args) {
        /* Create following Binary Tree
              1
            /    \
          2        3
         / \      / \
        4   5    6   7

        */
        VerticalSum tree = new VerticalSum();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);


        System.out.println("Following are the values of vertical sums with "
                + "the positions of the columns with respect to root ");
        tree.verticalSumMain(tree.root);
    }
}
