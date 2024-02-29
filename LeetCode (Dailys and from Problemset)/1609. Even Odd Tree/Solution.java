import java.util.LinkedList;
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

  public boolean isEvenOddTree(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode cur = root;
    q.add(cur);
    int level = 0, prevEvenLevel = Integer.MAX_VALUE, prevOddLevel = Integer.MIN_VALUE;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        cur = q.poll();
        if (level % 2 != 0) {
          if (cur.val % 2 != 0)
            return false;
          if (cur.val >= prevEvenLevel)
            return false;
          prevEvenLevel = cur.val;

        } else {
          if (cur.val % 2 == 0)
            return false;
          if (cur.val <= prevOddLevel)
            return false;
          prevOddLevel = cur.val;
        }
        if (cur.left != null)
          q.add(cur.left);
        if (cur.right != null)
          q.add(cur.right);
      }
      level += 1;
      prevEvenLevel = Integer.MAX_VALUE;
      prevOddLevel = Integer.MIN_VALUE;
    }
    return true;
  }
}