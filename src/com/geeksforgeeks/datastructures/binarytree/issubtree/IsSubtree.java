package com.geeksforgeeks.datastructures.binarytree.issubtree;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/03/17
 * Time: 9:45 PM
 * http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
 */
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class IsSubtree {
    Node root1, root2;


    private boolean areIdentical(Node root1, Node root2) {
        if ((root1 == null) && (root2 == null)) {
            return true;
        }
        if ((root1 == null) || (root2 == null)) {
            return false;
        }
        return ((root1.data == root2.data) && (areIdentical(root1.left, root2.left)) && areIdentical(root1.right, root2.right));
    }

    private boolean isSubtree(Node t, Node s) {
        if (s == null) {
            return true;
        }
        if (t == null) {
            return false;
        }
        if (areIdentical(t, s)) {
            return true;
        }
        return ((isSubtree(t.left, s)) || isSubtree(t.right, s));
    }


    public static void main(String[] args) {
        IsSubtree tree = new IsSubtree();
        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        tree.root1 = new Node(26);
        tree.root1.right = new Node(3);
        tree.root1.right.right = new Node(3);
        tree.root1.left = new Node(10);
        tree.root1.left.left = new Node(4);
        tree.root1.left.left.right = new Node(30);
        tree.root1.left.right = new Node(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        tree.root2 = new Node(10);
        tree.root2.right = new Node(6);
        tree.root2.left = new Node(4);
        tree.root2.left.right = new Node(30);

        if (tree.isSubtree(tree.root1, tree.root2)) {
            System.out.println("Tree 2 is subtree of Tree 1 ");
        } else {
            System.out.println("Tree 2 is not a subtree of Tree 1");
        }
    }
}
