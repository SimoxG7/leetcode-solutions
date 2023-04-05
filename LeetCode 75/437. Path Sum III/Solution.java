import java.util.HashMap;
import java.util.Map;

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

  long count = 0;
  long simi = 0;
  long numele = 0;

  public void pathi(TreeNode root, int targetSum, long simi) {
    if (root == null) {
      return;
    }
    if (simi == targetSum) {
      count++;
    }
    if (root.left != null) {
      pathi(root.left, targetSum, simi + root.left.val);
    }
    if (root.right != null) {
      pathi(root.right, targetSum, simi + root.right.val);
    }
  }

  public void inorder(TreeNode root, int targetSum) {
    if (root != null) {
      numele++;
      inorder(root.left, targetSum);
      pathi(root, targetSum, root.val);
      inorder(root.right, targetSum);
    }
  }

  public int pathSum(TreeNode root, int targetSum) {
    inorder(root, targetSum);
    return (int) count;
  }
}