package com.geeksforgeeks.datastructures.binarytree.btdiameter;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 18/11/16
 * Time: 7:36 AM
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
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

class Height {
    int h;
}

public class BTDiameter {
    Node root;

    private int diameter(Node root, Height height) {
        Height lh = new Height();
        Height rh = new Height();
        if (root == null) {
            height.h = 0;
            return 0;
        }
        lh.h++;
        rh.h++;
        int lDiameter = diameter(root.left, lh);
        int rDiameter = diameter(root.right, rh);
        height.h = Math.max(rh.h, lh.h) + 1;
        return Math.max((rh.h + lh.h + 1), Math.max(lDiameter, rDiameter));
    }

    public static void main(String[] args) {
        BTDiameter tree = new BTDiameter();
        Height height = new Height();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("The width/diameter of binary tree is: " + tree.diameter(tree.root, height));
    }
}
