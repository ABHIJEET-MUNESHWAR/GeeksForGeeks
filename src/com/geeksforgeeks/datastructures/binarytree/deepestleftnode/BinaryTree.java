package com.geeksforgeeks.datastructures.binarytree.deepestleftnode;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 23/11/16
 * Time: 7:43 AM
 * http://www.geeksforgeeks.org/deepest-left-leaf-node-in-a-binary-tree/
 * A java program to find the deepest left leaf in a binary tree
 */

// A Binary Tree node
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Level {
    int maxLevel = 0;
}

public class BinaryTree {
    Node root;
    Node result;

    private void deepestLeftLeaf(Node node) {
        Level level = new Level();
        deepestLeftLeafUtil(node, 0, level, false);
    }

    private void deepestLeftLeafUtil(Node node, int currLevel, Level level, boolean isLeft) {
        if (node == null) {
            return;
        }
        if ((isLeft) && (currLevel > level.maxLevel) && (node.left == null) && (node.right == null)) {
            level.maxLevel = currLevel;
            result = node;
        }
        deepestLeftLeafUtil(node.left, currLevel + 1, level, true);
        deepestLeftLeafUtil(node.right, currLevel + 1, level, false);
    }

    // Driver program to test above functions
    /*
       1
     /   \
    2     3
  /      /  \
 4      5    6
        \     \
         7     8
        /       \
       9         10
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.right.left.right = new Node(7);
        tree.root.right.right.right = new Node(8);
//        tree.root.right.left.right.left = new Node(9);
        tree.root.right.right.right.right = new Node(10);

        tree.deepestLeftLeaf(tree.root);
        if (tree.result != null)
            System.out.println("The deepest left child is " + tree.result.data);
        else
            System.out.println("There is no left leaf in the given tree");
    }
}
