/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

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

  private boolean path(ListNode head, TreeNode root, ListNode th) {
    if (head == null)
      return true;
    if (root == null)
      return false;

    if (root.val == head.val)
      return path(head.next, root.left, th) ||
          path(head.next, root.right, th);

    if (th.val == root.val)
      return path(head, root.left, th.next) || path(head, root.right, th.next);

    else
      return path(th, root.left, th) || path(th, root.right, th);
  }

  public boolean isSubPath(ListNode head, TreeNode root) {
    if (head == null)
      return true;
    if (root == null)
      return false;
    return path(head, root, head);
  }
}