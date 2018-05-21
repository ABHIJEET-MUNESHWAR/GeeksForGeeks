package com.geeksforgeeks.datastructures.binarytree.liss;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 20/11/16
 * Time: 8:47 PM
 * http://www.geeksforgeeks.org/largest-independent-set-problem/
 */
class Node {

  int data, liss;
  Node left, right;

  Node(int item) {
    data = item;
    liss = 0;
    left = right = null;
  }
}

public class LISS {

  Node root;

  private int getLISS2(Node node) {
    if (node == null) {
      return 0;
    }
    if (node.liss != 0) {
      return node.liss;
    }
    if ((node.left == null) && (node.right == null)) {
      return (1);
    }
    int lissExcl = getLISS2(node.left) + getLISS2(node.right);
    int lissIncl = 1;
    if (node.left != null) {
      lissIncl += getLISS2(node.left.left) + getLISS2(node.left.right);
    }
    if (node.right != null) {
      lissIncl += getLISS2(node.right.left) + getLISS2(node.right.right);
    }
    node.liss = (lissIncl > lissExcl) ? lissIncl : lissExcl;
    return node.liss;
  }

  public static void main(String args[]) {
    LISS tree = new LISS();
    tree.root = new Node(10);
    tree.root.left = new Node(20);
    tree.root.right = new Node(30);
    tree.root.right.right = new Node(60);
    tree.root.left.left = new Node(40);
    tree.root.left.right = new Node(50);
    tree.root.left.right.left = new Node(70);
    tree.root.left.right.right = new Node(80);
    System.out.println("The size of largest independent set is: " + tree.getLISS1(tree.root));
    System.out.println("The size of largest independent set is: " + tree.getLISS2(tree.root));
  }

  private int getLISS1(Node node) {
    if (node == null) {
      return 0;
    }
    int sizeExcl = getLISS1(node.left) + getLISS1(node.right);
    int sizeIncl = 1;
    if (node.left != null) {
      sizeIncl += getLISS1(node.left.left) + getLISS1(node.left.right);
    }
    if (node.right != null) {
      sizeIncl += getLISS1(node.right.left) + getLISS1(node.right.right);
    }
    return Math.max(sizeIncl, sizeExcl);
  }
}
