package com.geeksforgeeks.datastructures.binarytree.checkifbst;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetmuneshwar,
 * Date:    02/05/18,
 * Time:    9:41 AM
 */
class Node {

  int data;
  Node left, right, nextRight;

  Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
    this.nextRight = null;
  }
}

public class BinaryTree {

  Node root;

  public static void main(String args[]) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(4);
    tree.root.left = new Node(2);
    tree.root.right = new Node(5);
    tree.root.left.left = new Node(1);
    tree.root.left.right = new Node(3);

    if (tree.isBST()) {
      System.out.println("It is BST");
    } else {
      System.out.println("It is Not a BST");
    }
  }

  private boolean isBST() {
    return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBSTUtil(Node node, int minValue, int maxValue) {
    if (node == null) {
      return true;
    }
    if (node.data < minValue || node.data > maxValue) {
      return false;
    }
    return isBSTUtil(node.left, minValue, maxValue - 1) && isBSTUtil(node.right, minValue + 1,
        maxValue);
  }
}
