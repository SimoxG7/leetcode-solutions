import java.util.Objects;

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

  public int sumOfLeftLeaves(TreeNode root) {
    return dfs(root, false);
  }

  private int dfs(TreeNode node, boolean isLeft) {
    if (node == null) {
      return 0;
    }
    if (node.left == null && node.right == null) {
      return isLeft ? node.val : 0;
    }
    int leftSum = dfs(node.left, true);
    int rightSum = dfs(node.right, false);
    return leftSum + rightSum;
  }
}