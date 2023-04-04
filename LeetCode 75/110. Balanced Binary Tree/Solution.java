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

  public boolean isBalanced(TreeNode root) {
    return depth(root) != -1;
  }

  int depth(TreeNode root) {
    if (root == null) return 0;

    int lh = depth(root.left);
    if (lh == -1)
      return -1;

    int rh = depth(root.right);
    if (rh == -1)
      return -1;

    if (Math.abs(lh - rh) > 1)
      return -1;

    return 1 + Math.max(lh, rh);
  }
}