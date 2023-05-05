import java.util.ArrayList;
import java.util.List;

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

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    visit(root, res);
    return res;
  }

  private void visit(TreeNode root, List<Integer> nodes) {
    if (root == null) return;
    visit(root.left, nodes);
    nodes.add(root.val);
    visit(root.right, nodes);
  }
}