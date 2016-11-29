package com.geeksforgeeks.datastructures.binarytree.checkheightbalance;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 27/11/16
 * Time: 5:36 PM
 * http://www.geeksforgeeks.org/check-given-binary-tree-follows-height-property-red-black-tree/
 */
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

    private boolean isBalanced(Node node) {
        return isBalancedUtil(node, 0, 0);
    }

    private boolean isBalancedUtil(Node node, int maxH, int minH) {
        if (node == null) {
            maxH = minH = 0;
            return true;
        }
        int lMaxH = 0, lMinH = 0;
        int rMaxH = 0, rMinH = 0;
        if (!isBalancedUtil(node.left, lMaxH, lMinH)) {
            return false;
        }
        if (!isBalancedUtil(node.right, rMaxH, rMinH)) {
            return false;
        }
        maxH = Math.max(lMaxH, rMaxH) + 1;
        minH = Math.min(lMinH, rMinH) + 1;
        if (maxH <= (2 * minH)) {
            return true;
        }
        return false;
    }

    // Driver program to test the above functions
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        /*
                                          10
                                       /      \
                                     5         100
                                              /  \
                                           50    150
                                           /
                                          40
         */
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(100);
        tree.root.right.left = new Node(50);
        tree.root.right.right = new Node(150);
        tree.root.right.left.left = new Node(40);
        if (tree.isBalanced(tree.root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }

}
