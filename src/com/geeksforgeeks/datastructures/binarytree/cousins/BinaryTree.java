package com.geeksforgeeks.datastructures.binarytree.cousins;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 03/12/16
 * Time: 3:29 PM
 * http://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
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

    private boolean isCousin(Node node, Node a, Node b) {
        return ((level(node, a, 1) == level(node, b, 1)) && (!isSibling(node, a, b)));
    }

    private int level(Node node, Node ptr, int lvl) {
        if (node == null) {
            return 0;
        }
        if (node == ptr) {
            return lvl;
        }
        int l = level(node.left, ptr, lvl + 1);
        if (l != 0) {
            return l;
        }
        return level(node.right, ptr, lvl + 1);
    }

    private boolean isSibling(Node node, Node a, Node b) {
        if (node == null) {
            return false;
        }
        return ((node.left == a && node.right == b) || (node.left == b && node.right == a) || (isSibling(node.left, a, b) || (isSibling(node.right, a, b))));
    }

    //Driver program to test above functions
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(15);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        Node Node1, Node2;
        Node1 = tree.root.left.left;
        Node2 = tree.root.right.right;
        if (tree.isCousin(tree.root, Node1, Node2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
