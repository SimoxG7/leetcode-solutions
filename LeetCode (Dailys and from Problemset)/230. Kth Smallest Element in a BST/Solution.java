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

  int cont;

  public int kthSmallest(TreeNode root, int k) {
    cont = k;
    return dfs(root);
  }

  int dfs(TreeNode node) {
    if (node == null) return -1;
    int res = dfs(node.left);
    if (res != -1) return res;
    if (cont == 1) return node.val;
    cont--;
    return dfs(node.right);
  }
}