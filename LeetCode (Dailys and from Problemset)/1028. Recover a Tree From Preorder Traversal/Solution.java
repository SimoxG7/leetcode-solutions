import java.util.Stack;

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

  public TreeNode recoverFromPreorder(String traversal) {
    Stack<TreeNode> stack = new Stack<>();
    int index = 0;
    while (index < traversal.length()) {
      int dep = 0;
      while (index < traversal.length() && traversal.charAt(index) == '-') {
        dep += 1;
        index += 1;
      }
      int val = 0;
      while (index < traversal.length() && Character.isDigit(traversal.charAt(index))) {
        val = val * 10 + (traversal.charAt(index) - '0');
        index += 1;
      }
      TreeNode node = new TreeNode(val);
      while (stack.size() > dep)
        stack.pop();
      if (!stack.isEmpty()) {
        if (stack.peek().left == null) {
          stack.peek().left = node;
        } else {
          stack.peek().right = node;
        }
      }
      stack.push(node);
    }
    while (stack.size() > 1)
      stack.pop();
    return stack.peek();
  }
}
