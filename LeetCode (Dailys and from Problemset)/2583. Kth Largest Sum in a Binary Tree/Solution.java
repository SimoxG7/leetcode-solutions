import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
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

  public long kthLargestLevelSum(TreeNode root, int k) {
    PriorityQueue<Long> ans = new PriorityQueue<>(Collections.reverseOrder());
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      long sum = 0;
      int s = q.size();
      for (int i = 0; i < s; i++) {
        TreeNode c = q.poll();
        sum += c.val;
        if (c.left != null)
          q.add(c.left);
        if (c.right != null)
          q.add(c.right);
      }
      ans.add(sum);
    }
    if (ans.size() < k)
      return -1;
    for (int i = 0; i < k - 1; i++)
      ans.poll();
    return ans.poll();
  }
}