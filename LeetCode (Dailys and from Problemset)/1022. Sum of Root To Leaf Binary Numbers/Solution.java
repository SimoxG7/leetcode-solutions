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

  public int sumRootToLeaf(TreeNode root) {
    if (isLeaf(root)) return root.val;
    return sumLeafs(root.left, root.val) + sumLeafs(root.right, root.val);
  }

  private int sumLeafs(TreeNode root, int currValue) {
    if (Objects.isNull(root)) return 0;
    int newCurrValue = (currValue << 1) + root.val;
    if (isLeaf(root)) return newCurrValue;
    return sumLeafs(root.left, newCurrValue) + sumLeafs(root.right, newCurrValue);
  }

  private boolean isLeaf(TreeNode root) {
    return Objects.isNull(root.left) && Objects.isNull(root.right);
  }
}