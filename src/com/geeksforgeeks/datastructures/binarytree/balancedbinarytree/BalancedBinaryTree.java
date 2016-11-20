package com.geeksforgeeks.datastructures.binarytree.balancedbinarytree;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 19/11/16
 * Time: 12:07 PM
 * http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
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

class Height {
    int h;
}

public class BalancedBinaryTree {
    Node root;

    boolean isBalanced(Node root, Height height) {
        if (root == null) {
            return true;
        }
        Height lHeight = new Height();
        Height rHeight = new Height();
        boolean l = isBalanced(root.left, lHeight);
        boolean r = isBalanced(root.right, rHeight);
        int lh = lHeight.h;
        int rh = rHeight.h;
        height.h = (lh > rh ? lh : rh) + 1;
        if (Math.abs(lh - rh) > 1) {
            return false;
        } else {
            return l && r;
        }
    }

    public static void main(String args[]) {
        Height height = new Height();

        /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7         */
        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);

        if (tree.isBalanced(tree.root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
