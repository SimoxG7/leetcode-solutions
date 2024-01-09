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

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> leafs1 = new ArrayList<>();
    List<Integer> leafs2 = new ArrayList<>();  
    inOrderLeafs(root1, leafs1);
    inOrderLeafs(root2, leafs2);
    return leafs1.equals(leafs2);
  }

  public void inOrderLeafs(TreeNode root, List<Integer> leafs) {
    if (root == null) return;
    inOrderLeafs(root.left, leafs);
    if (root.left == null && root.right == null) leafs.add(root.val);
    inOrderLeafs(root.right, leafs);
  }
}