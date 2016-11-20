package com.geeksforgeeks.datastructures.binarytree.treeinorderpreorder;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 19/11/16
 * Time: 5:13 PM
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 */
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BuildTree {
    Node root;
    static int preIndex = 0;

    private Node buildTree(char[] in, char[] pre, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        Node tNode = new Node(pre[preIndex++]);
        if (inStart == inEnd) {
            return tNode;
        }
        int inIndex = search(in, inStart, inEnd, tNode.data);
        tNode.left = buildTree(in, pre, inStart, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
        return tNode;
    }

    private int search(char[] arr, int start, int end, int data) {
        int i;
        for (i = start; i < end; i++) {
            if (i == data) {
                return i;
            }
        }
        return i;
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.println(node.data);
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInOrder(root);
    }
}
