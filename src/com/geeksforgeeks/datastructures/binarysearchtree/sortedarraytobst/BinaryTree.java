package com.geeksforgeeks.datastructures.binarysearchtree.sortedarraytobst;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/12/16
 * Time: 6:03 PM
 */
// A binary tree node
class Node {

    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    private Node sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (end + start) / 2;
        Node node = new Node(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);
        return node;
    }

    /* A utility function to print preOrder traversal of BST */
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        tree.root = tree.sortedArrayToBST(arr, 0, n - 1);
        System.out.println("inOrder traversal of constructed BST");
        tree.preOrder(tree.root);
    }
}
