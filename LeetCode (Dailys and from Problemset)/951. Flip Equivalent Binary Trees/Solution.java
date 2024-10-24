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

  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    if (Objects.isNull(root2) && Objects.isNull(root1))
      return true;
    if (Objects.nonNull(root1) && Objects.isNull(root2))
      return false;
    if (Objects.nonNull(root2) && Objects.isNull(root1))
      return false;
    if (root1.val != root2.val)
      return false;
    boolean sameComp = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
    boolean revComp = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    return sameComp || revComp;
  }
}