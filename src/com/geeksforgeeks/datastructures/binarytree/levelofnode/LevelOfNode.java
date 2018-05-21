package com.geeksforgeeks.datastructures.binarytree.levelofnode;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 20/11/16
 * Time: 1:32 PM
 * http://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/
 */
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class LevelOfNode {
    Node root;

    private void getLevelOfNode(Node node, int data, int level) {
        if (node == null) {
            return;
        } else {
            if (node.data == data) {
                System.out.println(level);
            } else {
                getLevelOfNode(node.left, data, level + 1);
                getLevelOfNode(node.right, data, level + 1);
            }
        }

    }

    public static void main(String[] args) {
        LevelOfNode tree = new LevelOfNode();

        /* Constructing tree given in the above figure */
        tree.root = new Node(3);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);
        System.out.println("The level of node 1 is: ");
        tree.getLevelOfNode(tree.root, 1, 1);
    }
}