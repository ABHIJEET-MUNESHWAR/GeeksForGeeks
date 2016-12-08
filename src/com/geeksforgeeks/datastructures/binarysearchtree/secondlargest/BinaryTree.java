package com.geeksforgeeks.datastructures.binarysearchtree.secondlargest;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/12/16
 * Time: 7:38 PM
 * http://quiz.geeksforgeeks.org/second-largest-element-in-binary-search-tree-bst/
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
    int c = 0;

    private void secondLargest(Node node) {
        if ((node == null) || (c > 2)) {
            return;
        }
        secondLargest(node.right);
        c++;
        if (c == 2) {
            System.out.println(node.data);
            return;
        }
        secondLargest(node.left);
    }

    public static void main(String[] args) {
        /* Let us constructed BST shown in above example
                  10
                /    \
              5       50
             /       /  \
            1       40   100   */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(50);
        tree.root.left.left = new Node(1);
        tree.root.right.left = new Node(40);
        tree.root.right.right = new Node(100);
        tree.secondLargest(tree.root);
    }
}
