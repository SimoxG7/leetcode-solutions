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

  public TreeNode addOneRow(TreeNode root, int val, int depth) {
    int d = 1;
    if (depth == 1) {
      TreeNode t3 = new TreeNode(val, root, null);
      return t3;
    }
    aux(root, d, val, depth);
    return root;
  }

  public void aux(TreeNode root, int d, int val, int depth) {
    if (root == null) {
      return;
    }
    else {
      if (d == depth - 1) {
        TreeNode tree1 = new TreeNode(val, root.left, null);
        TreeNode tree2 = new TreeNode(val, null, root.right);
        root.left = tree1;
        root.right = tree2;
      }
      aux(root.left, d + 1, val, depth);
      aux(root.right, d + 1, val, depth);
    }
  }
}
