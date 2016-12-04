package com.geeksforgeeks.datastructures.binarytree.removenodesrootleafpathlengthk;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/12/16
 * Time: 12:16 PM
 * http://www.geeksforgeeks.org/remove-nodes-root-leaf-paths-length-k/
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

    /**
     * Method to print the tree in inorder fashion.
     *
     * @param node
     */
    private void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }

    private Node removeShortPathNodes(Node node, int k, int level) {
        if (node == null) {
            return null;
        }
        node.left = removeShortPathNodes(node.left, k, level + 1);
        node.right = removeShortPathNodes(node.right, k, level + 1);
        if ((node.left == null) && (node.right == null) && (level < k)) {
            return null;
        }
        return node;
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int k = 4;
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);
        tree.root.right.right = new Node(6);
        tree.root.right.right.left = new Node(8);
        System.out.println("The inorder traversal of original tree is : ");
        tree.printInorder(tree.root);
        Node res = tree.removeShortPathNodes(tree.root, k, 1);
        System.out.println("");
        System.out.println("The inorder traversal of modified tree is : ");
        tree.printInorder(res);
    }
}
