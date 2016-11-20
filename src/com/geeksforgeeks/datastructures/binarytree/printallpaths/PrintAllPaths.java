package com.geeksforgeeks.datastructures.binarytree.printallpaths;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 15/11/16
 * Time: 7:36 AM
 * http://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
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

public class PrintAllPaths {
    Node root;

    private void printAllPaths(Node root, int[] paths, int pathLen) {
        if (root == null) {
            return;
        }
        paths[pathLen] = root.data;
        pathLen++;
        if ((root.left == null) && (root.right == null)) {
            printPath(paths, pathLen);
        } else {
            printAllPaths(root.left, paths, pathLen);
            printAllPaths(root.right, paths, pathLen);
        }
    }

    private void printPath(int[] paths, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(paths[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrintAllPaths tree = new PrintAllPaths();
        int[] paths = new int[10];
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.printAllPaths(tree.root, paths, 0);
    }
}
