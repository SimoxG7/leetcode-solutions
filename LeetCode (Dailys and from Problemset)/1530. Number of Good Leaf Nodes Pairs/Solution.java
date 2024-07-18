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

  int res = 0;

  int[] dfs(TreeNode root, int distance) {
    if (root == null)
      return new int[distance + 1];
    if (root.left == null && root.right == null) {
      int[] res = new int[distance + 1];
      res[1]++;
      return res;
    }

    int[] left = dfs(root.left, distance);
    int[] right = dfs(root.right, distance);
    for (int i = 0; i < left.length; i++) {
      for (int j = distance - 1; j >= 0; j--) {
        if (i + j <= distance) {
          res += left[i] * right[j];
        }
      }
    }

    int res[] = new int[distance + 1];
    for (int i = res.length - 2; i >= 1; i--) {
      res[i + 1] = left[i] + right[i];
    }
    return res;
  }

  public int countPairs(TreeNode root, int distance) {
    dfs(root, distance);
    return res;
  }
}