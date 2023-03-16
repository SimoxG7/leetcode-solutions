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

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isValidBST(root, null, null);
  }

  private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
    if (root == null) {
      return true;
    }

    if (min != null && root.val <= min.val) {
      return false;
    }

    if (max != null && root.val >= max.val) {
      return false;
    }
    return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
  }
}
