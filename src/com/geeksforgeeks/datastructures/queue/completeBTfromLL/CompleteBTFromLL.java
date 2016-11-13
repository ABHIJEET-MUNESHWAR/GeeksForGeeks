package com.geeksforgeeks.datastructures.queue.completeBTfromLL;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 12/11/16
 * Time: 11:45 PM
 * http://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
 */

import java.util.*;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;

    BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class CompleteBTFromLL {
    ListNode head;
    BinaryTreeNode root;

    private void push(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }

    private BinaryTreeNode convertLLToCompleteBT(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if (head == null) {
            return null;
        }
        root = new BinaryTreeNode(head.data);
        queue.add(root);
        head = head.next;
        while (head != null) {
            BinaryTreeNode parent = queue.poll();
            BinaryTreeNode leftChild = null, rightChild = null;
            leftChild = new BinaryTreeNode(head.data);
            queue.add(leftChild);
            head = head.next;
            if (head != null) {
                rightChild = new BinaryTreeNode(head.data);
                queue.add(rightChild);
                head = head.next;
            }
            parent.left = leftChild;
            parent.right = rightChild;
        }
        return root;
    }

    private void inorderTraversal(BinaryTreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        CompleteBTFromLL completeBTFromLL = new CompleteBTFromLL();
        completeBTFromLL.push(36);
        completeBTFromLL.push(30);
        completeBTFromLL.push(25);
        completeBTFromLL.push(15);
        completeBTFromLL.push(12);
        completeBTFromLL.push(10);
        BinaryTreeNode node = completeBTFromLL.convertLLToCompleteBT(completeBTFromLL.root);
        System.out.println("The converted BT is: ");
        completeBTFromLL.inorderTraversal(node);
    }
}
