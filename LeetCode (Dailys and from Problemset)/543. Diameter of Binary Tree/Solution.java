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
  
  private int maxdepth;

  public int diameterOfBinaryTree(TreeNode root) {
    maxdepth = 0;
    depth(root);
    return maxdepth;
  }

  private int depth(TreeNode root) {
    if (root == null) return 0;
  
    int left = depth(root.left);
    int right = depth(root.right);

    maxdepth = Math.max(maxdepth, left + right);

    return Math.max(left, right) + 1;
  }
}