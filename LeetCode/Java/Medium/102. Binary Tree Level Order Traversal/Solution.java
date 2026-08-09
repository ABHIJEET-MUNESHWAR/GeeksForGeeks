/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root==null){
          return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
          int qSize = queue.size();
          List<Integer> list = new ArrayList<>();
          for (int i = 0; i < qSize; i++) {
            TreeNode node = queue.remove();
            list.add(node.val);
            if (node.left != null) {
              queue.add(node.left);
            }
            if (node.right != null) {
              queue.add(node.right);
            }
          }
          lists.add(list);
        }
        return lists;
    }
}