package com.geeksforgeeks.datastructures.binarytree.checkifsubtree;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 20/11/16
 * Time: 2:13 PM
 * http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
 */
class Node {
    int data;
    Node left, right, nextRight;

    Node(int item) {
        data = item;
        left = right = nextRight = null;
    }
}

public class BinaryTree {
    Node root1, root2;

    private boolean isSubtree(Node t, Node s) {
        if (t == null) {
            return false;
        }
        if (s == null) {
            return true;
        }
        if (areIdentical(t, s)) {
            return true;
        }
        return (isSubtree(t.left, s) || isSubtree(t.right, s));
    }

    private boolean areIdentical(Node root1, Node root2) {
        if ((root1 == null) && (root2 == null)) {
            return true;
        }
        if ((root1 == null) || (root2 == null)) {
            return false;
        }
        return ((root1.data == root2.data) && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();

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

        if (tree.isSubtree(tree.root1, tree.root2))
            System.out.println("Tree 2 is subtree of Tree 1 ");
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");
    }
}
