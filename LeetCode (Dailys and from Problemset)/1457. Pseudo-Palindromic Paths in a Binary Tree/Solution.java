import java.util.ArrayList;
import java.util.List;

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

  int count = 0;
  List<Integer> path = new ArrayList<>();

  public int pseudoPalindromicPaths(TreeNode root) {
    dfs(root, 0);
    return count;
  }

  public void dfs(TreeNode root, int parity) {
    if (root == null)
      return;

    parity ^= (1 << root.val); // Toggle the bit at the position of root.val

    // If it is a leaf node
    if (root.left == null && root.right == null) {
      if ((parity & (parity - 1)) == 0) { // Check if at most one bit is set
        count++;
      }
      return;
    }

    dfs(root.left, parity);
    dfs(root.right, parity);
  }
}