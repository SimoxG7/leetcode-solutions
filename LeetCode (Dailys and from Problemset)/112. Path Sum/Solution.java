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

  public boolean rootToLeafPathSum(TreeNode root, int targetSum, int currSum) {
    if (root == null)
      return false;
    if (root.left == null && root.right == null) {
      currSum = currSum + root.val;
      if (currSum == targetSum)
        return true;
    }
    return rootToLeafPathSum(root.left, targetSum, currSum + root.val)
        || rootToLeafPathSum(root.right, targetSum, currSum + root.val);
  }

  public boolean hasPathSum(TreeNode root, int targetSum) {
    return rootToLeafPathSum(root, targetSum, 0);
  }
}