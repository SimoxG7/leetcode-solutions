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

  private int min = Integer.MAX_VALUE;

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    helper(root, 1);
    return min;
  }

  private void helper(TreeNode root, int depth) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      min = Math.min(min, depth);
    } else {
      helper(root.left, depth+1);
      helper(root.right, depth+1);
    }
  }
}