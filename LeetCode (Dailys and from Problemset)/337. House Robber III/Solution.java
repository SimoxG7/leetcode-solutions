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

  public int rob(TreeNode root) {
    if (Objects.isNull(root)) {
      return 0;
    }
    rob(root.left);
    rob(root.right);
    int robNode = root.val;
    int dontRobNode = 0;
    if (Objects.nonNull(root.left)) {
      dontRobNode += root.left.val;
      if (Objects.nonNull(root.left.left)) {
        robNode += root.left.left.val;
      }
      if (Objects.nonNull(root.left.right)) {
        robNode += root.left.right.val;
      }
    }
    if (Objects.nonNull(root.right)) {
      dontRobNode += root.right.val;
      if (Objects.nonNull(root.right.left)) {
        robNode += root.right.left.val;
      }
      if (Objects.nonNull(root.right.right)) {
        robNode += root.right.right.val;
      }
    }
    root.val = Math.max(robNode, dontRobNode);
    return root.val;
  }
}