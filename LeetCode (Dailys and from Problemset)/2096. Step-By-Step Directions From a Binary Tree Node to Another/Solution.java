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

  int depth(TreeNode node, int val) {
    if (node == null)
      return -1;

    if (node.val == val)
      return 0;

    int left = depth(node.left, val);
    int right = depth(node.right, val);

    if (left == -1 && right == -1)
      return -1;
    if (left == -1)
      return 1 + right;
    if (right == -1)
      return 1 + left;

    return 1 + Math.min(left, right);
  }

  boolean depth_end(TreeNode node, int val, StringBuilder temp) {
    if (node == null)
      return false;

    if (node.val == val)
      return true;

    temp.append('L');
    if (depth_end(node.left, val, temp))
      return true;
    temp.deleteCharAt(temp.length() - 1);
    temp.append('R');
    if (depth_end(node.right, val, temp))
      return true;
    temp.deleteCharAt(temp.length() - 1);
    return false;

  }

  TreeNode ancestor(TreeNode node, int s, int e) {
    if (node == null)
      return null;

    if (node.val == s || node.val == e)
      return node;

    TreeNode left = ancestor(node.left, s, e);
    TreeNode right = ancestor(node.right, s, e);

    if (left != null && right != null)
      return node;
    if (left != null)
      return left;
    if (right != null)
      return right;
    return null;
  }

  public String getDirections(TreeNode root, int startValue, int destValue) {

    TreeNode lca = ancestor(root, startValue, destValue);

    StringBuilder answer = new StringBuilder();

    int start_depth = depth(lca, startValue);

    for (int i = 1; i <= start_depth; i++)
      answer.append("U");

    StringBuilder end_depth = new StringBuilder();
    depth_end(lca, destValue, end_depth);

    answer.append(end_depth);

    return answer.toString();

  }
}