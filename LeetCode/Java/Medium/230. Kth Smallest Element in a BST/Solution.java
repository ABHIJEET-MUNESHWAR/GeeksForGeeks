/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int answer = 0;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverseTree(root, k);
        return answer;
    }

    private void traverseTree(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverseTree(root.left, k);
        count++;
        if (k == count) {
            answer = root.val;
            return;
        }
        traverseTree(root.right, k);
    }
}