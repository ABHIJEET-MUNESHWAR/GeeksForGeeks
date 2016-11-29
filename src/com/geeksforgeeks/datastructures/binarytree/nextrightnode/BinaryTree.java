package com.geeksforgeeks.datastructures.binarytree.nextrightnode;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 23/11/16
 * Time: 8:21 AM
 * http://www.geeksforgeeks.org/find-next-right-node-of-a-given-key/
 */

import java.util.*;

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

    private Node nextRight(Node first, int k) {
        if (first == null) {
            return null;
        }
        Queue<Node> queueNodes = new LinkedList<>();
        Queue<Integer> queueLevels = new LinkedList<>();
        int level = 0;
        queueLevels.add(level);
        queueNodes.add(first);
        while (!queueNodes.isEmpty()) {
            Node node = queueNodes.poll();
            level = queueLevels.poll();
            if (node.data == k) {
                if ((queueLevels.isEmpty()) || (queueLevels.peek() != level)) {
                    return null;
                }
                return queueNodes.peek();
            }
            if (node.left != null) {
                queueNodes.add(node.left);
                queueLevels.add(level + 1);
            }
            if (node.right != null) {
                queueNodes.add(node.right);
                queueLevels.add(level + 1);
            }
        }
        return null;
    }

    private void test(Node node, int k) {
        Node nr = nextRight(node, k);
        if (nr == null) {
            System.out.println("No next right node found for " + k);
        } else {
            System.out.println("Next Right of " + k + " is " + nr.data);
        }
    }

    /*
                  10
               /      \
              2         6
           /   \         \
          8    4          5
     */
    // Driver program to test above functions
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.right.right = new Node(5);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(4);

        tree.test(tree.root, 10);
        tree.test(tree.root, 2);
        tree.test(tree.root, 6);
        tree.test(tree.root, 5);
        tree.test(tree.root, 8);
        tree.test(tree.root, 4);

    }
}
