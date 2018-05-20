package com.geeksforgeeks.datastructures.binarytree.iterativepostorder;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeetashokmuneshwar,
 * Date:    20/05/18,
 * Time:    8:28 PM
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

public class BinaryTree {

  Node root;

  public static void main(String args[]) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.left = new Node(6);
    tree.root.right.right = new Node(7);
    tree.preOrderWithTwoStacks(tree.root);
    tree.preOrderWithOneStacks(tree.root);
  }

  private void preOrderWithOneStacks(Node root) {
  }

  private void preOrderWithTwoStacks(Node root) {
    if (root == null) {
      return;
    }
    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();
    stack1.push(root);
    while (!stack1.isEmpty()) {
      Node node = stack1.pop();
      stack2.push(node);
      if (node.left != null) {
        stack1.push(node.left);
      }
      if (node.right != null) {
        stack1.push(node.right);
      }
    }
    while (!stack2.isEmpty()) {
      Node node = stack2.pop();
      System.out.println(node.data);
    }
  }
}
