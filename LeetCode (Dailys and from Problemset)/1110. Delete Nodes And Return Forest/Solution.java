import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
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

  List<TreeNode> ans = new ArrayList<>();

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    if (root == null || to_delete.length == 0)
      return ans;
    // if nothing to delete
    if (to_delete.length == 0) {
      ans.add(root);
      return ans;
    }

    Deque<TreeNode[]> q = new ArrayDeque<>(); // curr, parent
    Set<Integer> set = new HashSet<>();
    for (int i : to_delete) {
      set.add(i);
    }
    // if root is not required to be deleted
    if (!set.contains(root.val))
      ans.add(root);

    q.add(new TreeNode[] { root, null });
    util(q, set);
    return ans;
  }

  void util(Deque<TreeNode[]> q, Set<Integer> set) {
    while (!q.isEmpty()) {
      TreeNode[] curr = q.poll();
      TreeNode node = curr[0];
      TreeNode parent = curr[1];

      if (!set.contains(node.val)) { // just iterate with childrens
        if (node.left != null)
          q.add(new TreeNode[] { node.left, node });
        if (node.right != null)
          q.add(new TreeNode[] { node.right, node });
      } else { // if need to be deleted
        // if curr is t be deleted, both left & right are part of answer.
        if (node.left != null) {
          if (!set.contains(node.left.val)) {
            ans.add(node.left);
          }
          q.add(new TreeNode[] { node.left, node });
        }
        if (node.right != null) {
          if (!set.contains(node.right.val)) {
            ans.add(node.right);
          }
          q.add(new TreeNode[] { node.right, node });
        }

        if (parent != null) {
          if (parent.left == node) {
            parent.left = null;
          } else {
            parent.right = null;
          }
        }
      }
    }
  }
}