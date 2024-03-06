import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class Solution2 {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head.next;

    while (slow != fast) {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }

    return true;
  }
}

// O(n) sol

// public boolean hasCycle(ListNode head) {
// List<ListNode> lst = new ArrayList<>();
// while (head != null) {
// if (lst.contains(head)) return true;
// lst.add(head);
// head = head.next;
// }
// return false;
// }