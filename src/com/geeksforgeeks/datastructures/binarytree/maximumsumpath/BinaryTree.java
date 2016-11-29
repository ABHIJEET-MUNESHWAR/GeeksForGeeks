package com.geeksforgeeks.datastructures.binarytree.maximumsumpath;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 20/11/16
 * Time: 5:46 PM
 * http://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
 */
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Maximum {
    int maxNo = Integer.MIN_VALUE;
}

public class BinaryTree {
    Node root;
    Maximum max = new Maximum();
    Node targetLeaf = null;

    private boolean printPath(Node node, Node targetLeaf) {
        if (node == null) {
            return false;
        }
        if ((node == targetLeaf) || (printPath(node.left, targetLeaf)) || (printPath(node.right, targetLeaf))) {
            System.out.println(node.data);
            return true;
        }
        return false;
    }

    private int maxSumPath() {
        if (root == null) {
            return 0;
        }
        getTargetLeaf(root, max, 0);
        printPath(root, targetLeaf);
        return max.maxNo;
    }

    private void getTargetLeaf(Node node, Maximum maxSumRef, int currSum) {
        if (node == null) {
            return;
        }
        currSum = currSum + node.data;
        if ((node.left == null) && (node.right == null)) {
            if (currSum > maxSumRef.maxNo) {
                maxSumRef.maxNo = currSum;
                targetLeaf = node;
            }
        }
        getTargetLeaf(node.left, maxSumRef, currSum);
        getTargetLeaf(node.right, maxSumRef, currSum);
    }

    // driver function to test the above functions
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        System.out.println("Following are the nodes " +
                "on maximum sum path");
        int sum = tree.maxSumPath();
        System.out.println("");
        System.out.println("Sum of nodes is : " + sum);
    }
}
