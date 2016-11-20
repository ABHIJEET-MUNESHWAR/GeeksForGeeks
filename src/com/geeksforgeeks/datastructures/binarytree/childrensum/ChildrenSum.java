package com.geeksforgeeks.datastructures.binarytree.childrensum;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 15/11/16
 * Time: 10:03 PM
 * http://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 * Asked in: Adobe, Amazon, Goldman Sachs
 */

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class ChildrenSum {
    Node root;

    private boolean checkChildrenSum(Node node) {
        int leftData = 0;
        int rightData = 0;
        if ((node == null) || ((node.left == null) && (node.right == null))) {
            return true;
        } else {
            if (node.left != null) {
                leftData = node.left.data;
            }
            if (node.right != null) {
                rightData = node.right.data;
            }
            return ((node.data == (leftData + rightData)) && (checkChildrenSum(node.left)) && (checkChildrenSum(node.right)));
        }
    }

    public static void main(String[] args) {
        ChildrenSum tree = new ChildrenSum();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(2);
        boolean isSatisfies = tree.checkChildrenSum(tree.root);
        if (isSatisfies) {
            System.out.println("The given tree satisfies children sum property.");
        } else {
            System.out.println("The given tree doesn't satisfy children sum property.");
        }
    }
}
