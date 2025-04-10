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

  private int getHeight(TreeNode root) {
    if (null == root)
      return 0;
    return 1 + Math.max(getHeight(root.left), getHeight(root.right));
  }

  TreeNode lca;

  private boolean traverse(TreeNode root, int depth, int deepest) {
    if (null == root)
      return false;

    boolean leftSide = traverse(root.left, depth + 1, deepest);
    boolean rightSide = traverse(root.right, depth + 1, deepest);

    if (depth == deepest) {
      lca = root;
      return true;
    }

    if (leftSide && rightSide)
      lca = root;

    return (leftSide || rightSide);
  }

  public TreeNode lcaDeepestLeaves(TreeNode root) {
    int deepest = getHeight(root);
    lca = null;

    traverse(root, 1, deepest);

    return lca;
  }
}