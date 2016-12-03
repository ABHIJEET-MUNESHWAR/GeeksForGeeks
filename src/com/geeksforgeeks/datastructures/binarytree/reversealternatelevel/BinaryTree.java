package com.geeksforgeeks.datastructures.binarytree.reversealternatelevel;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 03/12/16
 * Time: 2:55 PM
 * http://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/
 */
class Node {
    char data;
    Node left, right;

    Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    Node root;

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    private void reverseAlternate(Node node) {
        if (node == null) {
            return;
        }
        reverseAlternate(node.left, node.right, 0);
    }

    private void reverseAlternate(Node root1, Node root2, int level) {
        if ((root1 == null) || (root2 == null)) {
            return;
        }
        if (level % 2 == 0) {
            char t;
            t = root1.data;
            root1.data = root2.data;
            root2.data = t;
        }
        reverseAlternate(root1.left, root2.right, level + 1);
        reverseAlternate(root1.right, root2.left, level + 1);
    }


    public static void main(String[] args) {
        /* Create following Binary Tree
        Input
               a
            /     \
           b       c
         /  \     /  \
        d    e    f    g
       / \  / \  / \  / \
       h  i j  k l  m  n  o


        Output:
               a
            /     \
           c       b
         /  \     /  \
        d    e    f    g
       / \  / \  / \  / \
      o  n m  l k  j  i  h
        */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node('a');
        tree.root.left = new Node('b');
        tree.root.right = new Node('c');
        tree.root.left.left = new Node('d');
        tree.root.left.right = new Node('e');
        tree.root.right.left = new Node('f');
        tree.root.right.right = new Node('g');
        tree.root.left.left.left = new Node('h');
        tree.root.left.left.right = new Node('i');
        tree.root.left.right.left = new Node('j');
        tree.root.left.right.right = new Node('k');
        tree.root.right.left.left = new Node('l');
        tree.root.right.left.right = new Node('m');
        tree.root.right.right.left = new Node('n');
        tree.root.right.right.right = new Node('o');
        System.out.println("Inorder Traversal of given tree");
        tree.printInOrder(tree.root);

        tree.reverseAlternate(tree.root);
        System.out.println("");
        System.out.println("");
        System.out.println("Inorder Traversal of modified tree");
        tree.printInOrder(tree.root);
    }
}
