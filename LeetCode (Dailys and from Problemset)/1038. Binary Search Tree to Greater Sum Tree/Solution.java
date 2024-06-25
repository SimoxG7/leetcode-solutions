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

  private int globalSum;

  private TreeNode postExtremeLeftFunc(TreeNode node) {
    TreeNode post = node.right;
    while (post.left != null && post.left != node) {
      post = post.left;
    }
    return post;
  }

  public TreeNode bstToGst(TreeNode root) {
    globalSum = 0;
    TreeNode node = root;

    while (node != null) {
      TreeNode post = node.right;
      if (post == null) {
        globalSum += node.val;
        node.val = globalSum;
        node = node.left;
      } else {
        TreeNode postExtremeLeft = postExtremeLeftFunc(node);

        if (postExtremeLeft.left == null) {
          postExtremeLeft.left = node;
          node = node.right;
        } else {
          postExtremeLeft.left = null;
          globalSum += node.val;
          node.val = globalSum;
          node = node.left;
        }
      }
    }
    return root;
  }
}