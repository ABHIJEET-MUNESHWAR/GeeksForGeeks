package com.geeksforgeeks.datastructures.binarytree.maxwidth;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 20/11/16
 * Time: 11:55 AM
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

public class MaxWidth {
    Node root;

    private int getMaxWidth(Node node) {
        if (node == null) {
            return 0;
        }
        int h = height(node);
        int[] count = new int[10];
        int level = 0;
        getMaxWidthRec(node, count, level);
        return getMax(count, h);
    }

    private void getMaxWidthRec(Node node, int[] count, int level) {
        if (node != null) {
            count[level]++;
            getMaxWidthRec(node.left, count, level + 1);
            getMaxWidthRec(node.right, count, level + 1);
        }
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lHeight = height(node.left);
            int rHeight = height(node.right);
            return ((lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1));
        }
    }

    private int getMax(int[] count, int n) {
        int max = count[0];
        for (int i = 1; i < n; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }
        return max;
    }

    public static void main(String args[]) {
        MaxWidth tree = new MaxWidth();

        /*
        Constructed binary tree is:
              1
            /  \
           2    3
          / \    \
         4   5    8
                 / \
                6   7 */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(8);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.right = new Node(7);

        System.out.println("Maximum width is " + tree.getMaxWidth(tree.root));
    }
}
