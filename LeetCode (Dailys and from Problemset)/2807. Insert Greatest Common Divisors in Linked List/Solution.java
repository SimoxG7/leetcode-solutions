import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

  public ListNode insertGreatestCommonDivisors(ListNode head) {
    ListNode trueHead = head;
    ListNode prev = null;
    ListNode next = null;
    while (Objects.nonNull(head) && Objects.nonNull(head.next)) {
      prev = head;
      next = head.next;
      int gcd = gcdEuclids(prev.val, next.val);
      prev.next = new ListNode(gcd, next);
      head = next;
    }
    return trueHead;
  }

  private int gcdEuclids(int n1, int n2) {
    if (n2 == 0) return n1;
    return gcdEuclids(n2, n1 % n2);
  }
}