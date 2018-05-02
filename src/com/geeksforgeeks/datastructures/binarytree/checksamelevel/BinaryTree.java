package com.geeksforgeeks.datastructures.binarytree.checksamelevel;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 20/11/16
 * Time: 11:35 PM
 * http://www.geeksforgeeks.org/check-leaves-level/
 */
// Java program to check if all leaves are at same level

// A binary tree node
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Leaf {
    int leafLevel = 0;
}

public class BinaryTree {
    Node root;
    Leaf myLeaf = new Leaf();

    private boolean check(Node node) {
        int level = 0;
        return checkUtil(node, level, myLeaf);
    }

    private boolean checkUtil(Node node, int level, Leaf myLeaf) {
        if (node == null) {
            return true;
        }
        if ((node.left == null) && (node.right == null)) {
            if (myLeaf.leafLevel == 0) {
                myLeaf.leafLevel = level;
                return true;
            }
            return (level == myLeaf.leafLevel);
        }
        return ((checkUtil(node.left, level + 1, myLeaf)) && (checkUtil(node.right, level + 1, myLeaf)));
    }

    public static void main(String args[]) {
        // Let us create the tree as shown in the example
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(12);
        tree.root.left = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(9);
        tree.root.left.left.left = new Node(1);
        tree.root.left.right.left = new Node(2);
        if (tree.check(tree.root))
            System.out.println("Leaves are at same level");
        else
            System.out.println("Leaves are not at same level");
    }
}
