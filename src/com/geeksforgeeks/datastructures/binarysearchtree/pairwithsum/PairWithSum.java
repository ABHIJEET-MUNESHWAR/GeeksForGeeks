package com.geeksforgeeks.datastructures.binarysearchtree.pairwithsum;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * User: abhijeet
 * Date: 04/03/17
 * Time: 8:10 PM
 * http://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
 */
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class PairWithSum {
    Node root;

    private boolean isPairPresent(Node node, int target) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        boolean done1 = false, done2 = false;
        int val1 = 0, val2 = 0;
        Node curr1 = node, curr2 = node;
        while (true) {
            while (!done1) {
                if (curr1 != null) {
                    stack1.push(curr1);
                    curr1 = curr1.left;
                } else {
                    if (stack1.isEmpty()) {
                        done1 = true;
                    } else {
                        curr1 = stack1.pop();
                        val1 = curr1.data;
                        curr1 = curr1.right;
                        done1 = true;
                    }
                }
            }
            while (!done2) {
                if (curr2 != null) {
                    stack2.push(curr2);
                    curr2 = curr2.right;
                } else {
                    if (stack2.isEmpty()) {
                        done2 = true;
                    } else {
                        curr2 = stack2.pop();
                        val2 = curr2.data;
                        curr2 = curr2.left;
                        done2 = true;
                    }
                }
            }
            if ((val1 != val2) && ((val1 + val2) == target)) {
                System.out.println(val1 + " + " + val2 + " = " + target);
                return true;
            } else if ((val1 + val2) < target) {
                done1 = false;
            } else if ((val1 + val2) > target) {
                done2 = false;
            }
            if (val1 >= val2) {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        PairWithSum tree = new PairWithSum();
        tree.root = new Node(15);
        tree.root.left = new Node(10);
        tree.root.right = new Node(20);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(12);
        tree.root.right.left = new Node(16);
        tree.root.right.right = new Node(25);
        int target = 33;
        boolean isFound = tree.isPairPresent(tree.root, target);
        if (!isFound) {
            System.out.println("No such values are found");
        }
    }
}
