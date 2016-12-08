package com.geeksforgeeks.datastructures.binarytree.roottoleafsum;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 19/11/16
 * Time: 3:24 PM
 * http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 */
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class RootToLeafSum {
    Node root;

    private boolean hasPathSum(Node node, int sum) {
        if (node == null) {
            return (sum == 0);
        } else {
            boolean ans = false;
            int subSum = sum - node.data;
            if ((subSum == 0) && (node.left == null) && (node.right == null)) {
                return true;
            }
            if (node.left != null) {
                ans = ans || hasPathSum(node.left, subSum);
            }
            if (node.right != null) {
                ans = ans || hasPathSum(node.right, subSum);
            }
            return ans;
        }
    }

    public static void main(String args[]) {
        int sum = 21;

        /* Constructed binary tree is
              10
             /  \
           8     2
          / \   /
         3   5 2
        */
        RootToLeafSum tree = new RootToLeafSum();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);

        if (tree.hasPathSum(tree.root, sum))
            System.out.println("There is checkifbst root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
    }
}
