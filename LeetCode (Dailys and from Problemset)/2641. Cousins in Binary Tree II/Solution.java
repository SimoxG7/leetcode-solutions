import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

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

  public TreeNode replaceValueInTree(TreeNode root) {
    if (root == null)
      return root;
    TreeNode res = new TreeNode(0);
    Queue<TreeNode> resq = new LinkedList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    resq.offer(res);
    while (!q.isEmpty()) {
      int size = q.size();
      TreeNode[] t = new TreeNode[size];
      int sum = 0;
      for (int i = 0; i < size; i++) {
        t[i] = q.poll();
        if (Objects.nonNull(t[i].left)) {
          q.offer(t[i].left);
          sum += t[i].left.val;
        }
        if (Objects.nonNull(t[i].right)) {
          q.offer(t[i].right);
          sum += t[i].right.val;
        }
      }
      for (int i = 0; i < size; i++) {
        TreeNode curr = resq.poll();
        int cusins = sum - (Objects.nonNull(t[i].left) ? t[i].left.val : 0) - (Objects.nonNull(t[i].right) ? t[i].right.val : 0);
        if (Objects.nonNull(t[i].left)) {
          curr.left = new TreeNode(cusins);
          resq.offer(curr.left);
        }
        if (Objects.nonNull(t[i].right)) {
          curr.right = new TreeNode(cusins);
          resq.offer(curr.right);
        }
      }
    }
    return res;
  }
}