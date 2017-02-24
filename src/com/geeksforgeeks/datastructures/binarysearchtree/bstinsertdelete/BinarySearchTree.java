package com.geeksforgeeks.datastructures.binarysearchtree.bstinsertdelete;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 20/02/17
 * Time: 8:34 PM
 * http://quiz.geeksforgeeks.org/binary-search-tree-set-2-delete/
 */
public class BinarySearchTree {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    private void insert(int key) {
        root = insertUtil(root, key);
    }

    private Node insertUtil(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data) {
            root.left = insertUtil(root.left, key);
        } else if (key > root.data) {
            root.right = insertUtil(root.right, key);
        }
        return root;
    }

    private void inorder() {
        inorderUtil(root);
    }

    private void inorderUtil(Node node) {
        if (node == null) {
            return;
        }
        inorderUtil(node.left);
        System.out.println(node.data);
        inorderUtil(node.right);
    }

    private void deleteKey(int key) {
        root = deleteKeyUtil(root, key);
    }

    private Node deleteKeyUtil(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.data) {
            root.left = deleteKeyUtil(root.left, key);
        } else if (key > root.data) {
            root.right = deleteKeyUtil(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteKeyUtil(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
    }
}
