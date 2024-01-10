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

  private int result;

  public int amountOfTime(TreeNode root, int start) {
    DFS(root, start);
    return result;
  }

  private int DFS(TreeNode node, int start) {
    if (node == null)
      return 0;

    int leftDepth = DFS(node.left, start);
    int rightDepth = DFS(node.right, start);

    if (node.val == start) {
      result = Math.max(leftDepth, rightDepth);
      return -1;
    } else if (leftDepth >= 0 && rightDepth >= 0)
      return Math.max(leftDepth, rightDepth) + 1;

    result = Math.max(result, Math.abs(leftDepth - rightDepth));
    return Math.min(leftDepth, rightDepth) - 1;
  }
}