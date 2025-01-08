import java.util.ArrayList;
import java.util.List;
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

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> accumulator = new ArrayList<>();
    dfs(root, new StringBuilder(), accumulator);
    return accumulator;
  }

  private void dfs(TreeNode root, StringBuilder currPath, List<String> accumulator) {
    if (Objects.isNull(root)) return;
    currPath = new StringBuilder(currPath);
    if (isLeaf(root)) {
      accumulator.add(currPath.append(root.val).toString());
    } else {
      dfs(root.left, new StringBuilder(currPath).append(root.val).append("->"), accumulator);
      dfs(root.right, new StringBuilder(currPath).append(root.val).append("->"), accumulator);
    }
  }

  private boolean isLeaf(TreeNode root) {
    return Objects.isNull(root.left) && Objects.isNull(root.right);
  }
}