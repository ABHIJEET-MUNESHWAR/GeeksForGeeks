package com.geeksforgeeks.datastructures.binarytree.SumRootToLeaf;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 24/11/16
 * Time: 7:49 AM
 * http://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
 */
// Java program to find sum of all numbers that are formed from root
// to leaf paths

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

    private int treePathsSum(Node node) {
        return treePathsSumUtil(node, 0);
    }

    private int treePathsSumUtil(Node node, int val) {
        if (node == null) {
            return 0;
        }
        val = val * 10 + node.data;
        if ((node.left == null) && (node.right == null)) {
            return val;
        }
        return ((treePathsSumUtil(node.left, val)) + (treePathsSumUtil(node.right, val)));
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        /*
                                          6
                                      /      \
                                    3          5
                                  /   \          \
                                 2     5          4
                                      /   \
                                     7     4
                      There are 4 leaves, hence 4 root to leaf paths:
                       Path                    Number
                      6->3->2                   632
                      6->3->5->7               6357
                      6->3->5->4               6354
                      6->5>4                    654
                    Answer = 632 + 6357 + 6354 + 654 = 13997
         */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(6);
        tree.root.left = new Node(3);
        tree.root.right = new Node(5);
        tree.root.right.right = new Node(4);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(4);
        tree.root.left.right.left = new Node(7);

        System.out.print("Sum of all paths is " +
                tree.treePathsSum(tree.root));
    }
}
