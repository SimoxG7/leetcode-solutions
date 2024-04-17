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

  String res = "";

  public String smallestFromLeaf(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    sb.append((char) (root.val + 'a'));
    helper(sb, root);
    return res;
  }

  public void helper(StringBuilder s, TreeNode root) {

    if (root == null)
      return;
    if (root.left == null && root.right == null) {
      StringBuilder temp1 = new StringBuilder(s);
      String temp = temp1.reverse().toString();
      if (res.equals("") || temp.compareTo(res) < 0)
        res = temp;
      return;
    }

    if (root.left != null) {
      char a = (char) (root.left.val + 'a');
      helper(s.append(a), root.left);
      s.deleteCharAt(s.length() - 1);
    }

    if (root.right != null) {
      char a = (char) (root.right.val + 'a');
      helper(s.append(a), root.right);
      s.deleteCharAt(s.length() - 1);
    }

  }
}