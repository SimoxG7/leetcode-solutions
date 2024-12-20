import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

  public TreeNode reverseOddLevels(TreeNode root) {
    if (root == null) {
      return null; // Return null if the tree is empty.
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root); // Start BFS with the root node.
    int level = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<TreeNode> currentLevelNodes = new ArrayList<>();

      // Process all nodes at the current level.
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        currentLevelNodes.add(node);

        if (node.left != null)
          queue.add(node.left);
        if (node.right != null)
          queue.add(node.right);
      }

      // Reverse node values if the current level is odd.
      if (level % 2 == 1) {
        int left = 0, right = currentLevelNodes.size() - 1;
        while (left < right) {
          int temp = currentLevelNodes.get(left).val;
          currentLevelNodes.get(left).val = currentLevelNodes.get(
              right).val;
          currentLevelNodes.get(right).val = temp;
          left++;
          right--;
        }
      }

      level++;
    }

    return root; // Return the modified tree root.
  }
}