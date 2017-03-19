package com.geeksforgeeks.datastructures.binarytree.rightview;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 19/03/17
 * Time: 6:46 PM
 */
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class RightView {
    Node root;
    int maxLevel = 0;

    private void rightView(Node node, int level) {
        if (node == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.println(node.data);
            maxLevel = level;
        }
        rightView(node.right, level + 1);
        rightView(node.left, level + 1);
    }

    /* testing for example nodes */
    public static void main(String args[]) {
        /*
          12
       /     \
     10       30
            /    \
          25      40
        /
       27


         */
        RightView tree = new RightView();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);
        tree.root.right.left.left = new Node(27);

        tree.rightView(tree.root, 1);
    }
}
