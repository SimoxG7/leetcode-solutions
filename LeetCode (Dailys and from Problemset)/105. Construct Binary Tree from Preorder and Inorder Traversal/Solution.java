import java.util.HashMap;
import java.util.Map;

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

  private int preorderIdx = 0;

  private TreeNode construct(int[] preorder, Map<Integer, Integer> map, int left, int right) {
    if (left > right)
      return null;
    int pval = preorder[preorderIdx];
    int inorderIdx = map.get(pval);

    TreeNode root = new TreeNode(pval);
    preorderIdx++;
    root.left = construct(preorder, map, left, inorderIdx - 1);
    root.right = construct(preorder, map, inorderIdx + 1, right);
    return root;

  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> map = new HashMap<>();
    int len = inorder.length;
    for (int i = 0; i < len; i++) {
      map.put(inorder[i], i);
    }

    return construct(preorder, map, 0, len - 1);
  }
}