package com.geeksforgeeks.datastructures.binarytree.NodeDistance;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 27/11/16
 * Time: 3:36 PM
 * http://www.geeksforgeeks.org/find-distance-two-given-nodes/
 * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
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

public class BinaryTree {
    Node root;

    private int findDistance(int n1, int n2) {
        int firstLevel = getLevel(root, n1, 0);
        int secondLevel = getLevel(root, n2, 0);
        Node lca = findLCA(root, n1, n2);
        int lcaLevel = getLevel(root, lca.data, 0);
        return (firstLevel + secondLevel - (2 * lcaLevel));
    }

    private Node findLCA(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }
        if ((node.data == n1) || (node.data == n2)) {
            return node;
        }
        Node leftLCA = findLCA(node.left, n1, n2);
        Node rightLCA = findLCA(node.right, n1, n2);
        if ((leftLCA != null) && (rightLCA != null)) {
            return node;
        }
        return ((leftLCA != null) ? leftLCA : rightLCA);
    }

    private int getLevel(Node node, int data, int level) {
        if (node == null) {
            return 0;
        }
        if (node.data == data) {
            return level;
        }
        int downLevel = getLevel(node.left, data, level + 1);
        if (downLevel != 0) {
            return downLevel;
        }
        downLevel = getLevel(node.right, data, level + 1);
        return downLevel;
    }

    public static void main(String[] args) {
        /*
                                          1
                                      /      \
                                    2          3
                                  /   \       /  \
                                 4     5     6    7
                                              \
                                               8
         */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " +
                tree.findDistance(4, 5));
        System.out.println("LCA(4, 6) = " +
                tree.findDistance(4, 6));
        System.out.println("LCA(3, 4) = " +
                tree.findDistance(3, 4));
        System.out.println("LCA(2, 4) = " +
                tree.findDistance(2, 4));
        System.out.println("LCA(8, 5) = " +
                tree.findDistance(8, 5));

    }
}
