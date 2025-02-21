import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
class FindElements {

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

  private final TreeNode root;
  private final Set<Integer> numSet;

  public FindElements(TreeNode root) {
    numSet = new HashSet<>();
    this.root = root;
    this.root.val = 0;
    numSet.add(this.root.val);
    dfs(this.root.left, this.root.val, false);
    dfs(this.root.right, this.root.val, true);
  }

  public boolean find(int target) {
    return numSet.contains(target);
  }

  private void dfs(TreeNode root, int val, boolean isRight) {
    if (Objects.nonNull(root)) {
      root.val = 2 * val + (isRight ? 2 : 1);
      numSet.add(root.val);
      dfs(root.left, root.val, false);
      dfs(root.right, root.val, true);
    }
  }

}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */