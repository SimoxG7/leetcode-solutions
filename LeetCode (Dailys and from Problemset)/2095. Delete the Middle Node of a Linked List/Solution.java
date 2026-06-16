import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

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

	public ListNode deleteMiddle(ListNode head) {
    if (isNull(head) || isNull(head.next)) return null;
    ListNode slow = head;
    ListNode fast = head.next.next;
    while (nonNull(fast) && nonNull(fast.next)){
      slow = slow.next;
      fast = fast.next.next;
    }
    slow.next = slow.next.next;
    return head;
	}

}