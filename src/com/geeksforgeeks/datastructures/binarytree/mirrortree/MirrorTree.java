package com.geeksforgeeks.datastructures.binarytree.mirrortree;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 14/11/16
 * Time: 10:39 PM
 */
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class MirrorTree {
    Node root;

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);

    }

    private Node mirrorTree(Node root) {
        if (root == null) {
            return root;
        }
        Node left = mirrorTree(root.left);
        Node right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("InOrder traversal of input tree:");
        tree.inOrder(tree.root);
        tree.root = tree.mirrorTree(tree.root);
        System.out.println("InOrder traversal of output tree:");
        tree.inOrder(tree.root);
    }
}
