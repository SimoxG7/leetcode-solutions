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

  public ListNode sortList(ListNode head) {
    ListNode start = new ListNode(0);
    start.next = head;
    int n = 0;
    while (head != null) {
      head = head.next;
      n++;
    }

    for (int step = 1; step < n; step <<= 1) {
      ListNode prev = start;
      ListNode curr = start.next;
      while (curr != null) {
        ListNode left = curr;
        ListNode right = split(left, step);
        curr = split(right, step);
        prev = merge(left, right, prev);
      }
    }

    return start.next;
  }

  private ListNode split(ListNode head, int step) {
    if (head == null)
      return null;

    for (int i = 1; head.next != null && i < step; i++) {
      head = head.next;
    }

    ListNode right = head.next;
    head.next = null;
    return right;
  }

  private ListNode merge(ListNode left, ListNode right, ListNode prev) {
    ListNode cur = prev;
    while (left != null && right != null) {
      if (left.val < right.val) {
        cur.next = left;
        left = left.next;
      } else {
        cur.next = right;
        right = right.next;
      }
      cur = cur.next;
    }

    if (left != null)
      cur.next = left;
    else if (right != null)
      cur.next = right;
    while (cur.next != null)
      cur = cur.next;
    return cur;
  }
}