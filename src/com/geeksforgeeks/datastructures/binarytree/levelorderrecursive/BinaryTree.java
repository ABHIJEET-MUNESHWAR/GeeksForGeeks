package com.geeksforgeeks.datastructures.binarytree.levelorderrecursive;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    09/06/18,
 * Time:    2:46 PM
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

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.left = new Node(6);
    tree.root.right.right = new Node(7);
    tree.levelOrder(tree.root);
  }

  private void levelOrder(Node node) {
    printLevelorder(node);
  }

  private void printLevelorder(Node node) {
    if (node == null) {
      return;
    }
    int height = findHeight(node);
    for (int i = 0; i < height; i++) {
      printLevel(root, 0, i);
    }
  }

  private int findHeight(Node node) {
    if (node == null) {
      return 0;
    }
    int leftHeight = findHeight(node.left) + 1;
    int rightHeight = findHeight(node.right) + 1;
    return leftHeight > rightHeight ? leftHeight : rightHeight;
  }

  private void printLevel(Node node, int currentlevel, int level) {
    if (node == null) {
      return;
    }
    if (currentlevel == level) {
      System.out.println(node.data);
    }
    printLevel(node.left, currentlevel + 1, level);
    printLevel(node.right, currentlevel + 1, level);
  }
}
