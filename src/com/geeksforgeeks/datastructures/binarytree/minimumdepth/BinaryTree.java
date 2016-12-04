package com.geeksforgeeks.datastructures.binarytree.minimumdepth;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/12/16
 * Time: 12:56 PM
 * http://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
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

public class BinaryTree {
    Node root;

    private int minimumDepth(Node node) {
        if (node == null) {
            return 0;
        }
        if ((node.left == null) && (node.right == null)) {
            return 1;
        }
        if (node.left == null) {
            return minimumDepth(node.right) + 1;
        }
        if (node.right == null) {
            return minimumDepth(node.left) + 1;
        }
        return (Math.min(minimumDepth(node.left), minimumDepth(node.right)) + 1);
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The minimum depth of binary tree is : " + tree.minimumDepth(tree.root));
    }
}
