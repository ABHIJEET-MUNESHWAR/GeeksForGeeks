package com.geeksforgeeks.datastructures.binarytree.foldable;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 20/11/16
 * Time: 12:31 PM
 * http://www.geeksforgeeks.org/foldable-binary-trees/
 */
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Foldable {
    Node root;

    private boolean isFoldable(Node node) {
        if (node == null) {
            return true;
        } else {
            return isFoldableUtil(node.left, node.right);
        }
    }

    private boolean isFoldableUtil(Node n1, Node n2) {
        if ((n1 == null) && (n2 == null)) {
            return true;
        }
        if ((n1 == null) || (n2 == null)) {
            return false;
        }
        return (isFoldableUtil(n1.left, n2.right) && isFoldableUtil(n1.right, n2.left));
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        Foldable tree = new Foldable();

        /* The constructed binary tree is
             1
           /   \
          2     3
           \    /
            4  5
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.left.right = new Node(5);

        if (tree.isFoldable(tree.root))
            System.out.println("tree is foldable");
        else
            System.out.println("Tree is not foldable");

    }
}
