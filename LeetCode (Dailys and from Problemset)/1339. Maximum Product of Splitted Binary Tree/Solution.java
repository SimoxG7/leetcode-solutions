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

  private long max = 0L;
  private final int MOD = 1_000_000_007;

  public int maxProduct(TreeNode root) {
    maxDfs(root, sumDfs(root), 0);
    return (int) (max % MOD);
  }

  private long sumDfs(TreeNode root) {
    if (Objects.isNull(root)) return 0L;
    return sumDfs(root.left) + sumDfs(root.right) + root.val;
  }

  private long maxDfs(TreeNode root, long totalSum, int level) {
    if (Objects.isNull(root)) return 0;
    long left = maxDfs(root.left, totalSum, level + 1);
    long right = maxDfs(root.right, totalSum, level + 1);
    long leftRightValSum = left + right + root.val;
    if (level != 0) {
      this.max = Math.max(this.max, leftRightValSum * (totalSum - leftRightValSum));
    }
    return leftRightValSum;
  }
}