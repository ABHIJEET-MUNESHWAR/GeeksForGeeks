package com.geeksforgeeks.datastructures.binarytree.NodesAtKDistanceFromLeaf;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 27/11/16
 * Time: 4:38 PM
 * http://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
 */
// A binary tree node
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

    private void printKDistantFromLeaf(Node node, int k) {
        boolean[] visited = new boolean[1000];
        int[] path = new int[1000];
        printKDistantFromLeafUtil(node, path, visited, 0, k);
    }

    private void printKDistantFromLeafUtil(Node node, int[] path, boolean[] visited, int pathLen, int k) {
        if (node == null) {
            return;
        }
        path[pathLen] = node.data;
        visited[pathLen] = false;
        pathLen++;
        if ((node.left == null) && (node.right == null) && (pathLen - k - 1 >= 0) && (!visited[pathLen - k - 1])) {
            System.out.println(path[pathLen - k - 1]);
            visited[pathLen - k - 1] = true;
            return;
        }
        printKDistantFromLeafUtil(node.left, path, visited, pathLen, k);
        printKDistantFromLeafUtil(node.right, path, visited, pathLen, k);
    }

    // Driver program to test the above functions
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        /*
                                          1
                                      /      \
                                    2          3
                                  /   \       /  \
                                 4     5     6    7
                                              \
                                               8
         */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        System.out.println(" Nodes at distance 2 are :");
        tree.printKDistantFromLeaf(tree.root, 2);
    }
}
