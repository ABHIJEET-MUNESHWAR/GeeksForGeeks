package com.geeksforgeeks.datastructures.binarytree.identicaltrees;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 13/11/16
 * Time: 10:51 PM
 * http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
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

public class IdenticalTrees {
    Node root1, root2;

    private boolean isIdentialTree(Node root1, Node root2) {
        if ((root1 == null) && (root2 == null)) {
            return true;
        } else {
            return ((root1.data == root2.data) && (isIdentialTree(root1.left, root2.left)) && (isIdentialTree(root1.right, root2.right)));
        }
    }

    public static void main(String[] args) {
        IdenticalTrees identicalTrees = new IdenticalTrees();
        identicalTrees.root1 = new Node(1);
        identicalTrees.root1.left = new Node(2);
        identicalTrees.root1.right = new Node(3);
        identicalTrees.root1.left.left = new Node(4);
        identicalTrees.root1.right = new Node(5);
        identicalTrees.root2 = new Node(1);
        identicalTrees.root2.left = new Node(2);
        identicalTrees.root2.right = new Node(3);
        identicalTrees.root2.left.left = new Node(4);
        identicalTrees.root2.right = new Node(5);
        boolean isIdential = identicalTrees.isIdentialTree(identicalTrees.root1, identicalTrees.root2);
        if (isIdential) {
            System.out.println("Both trees are identical");
        } else {
            System.out.println("Both trees are different");
        }
    }
}
