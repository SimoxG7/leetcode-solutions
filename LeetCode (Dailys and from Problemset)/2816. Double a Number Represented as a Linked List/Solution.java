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

  public ListNode doubleIt(ListNode head) {
    StringBuilder stringBuilder = new StringBuilder();
    ListNode start = head;
    while (Objects.nonNull(start)) {
      stringBuilder.append(start.val);
      start = start.next;
    }
    int toAdd = 0;

    for (int i = stringBuilder.length()-1; i >= 0; i--) {
      int val = Integer.parseInt(stringBuilder.charAt(i) + "") * 2 + toAdd;
      if (val >= 10) {
        toAdd = 1;
        val -= 10;
      } else {
        toAdd = 0;
      }
      stringBuilder.replace(i, i+1, val + "");
    }
    ListNode newHead = new ListNode();
    ListNode newStart = newHead;
    if (toAdd > 0) {
      newStart.val = toAdd;
      newStart.next = new ListNode();
      newStart = newStart.next;
    }
    for (int i = 0; i < stringBuilder.length(); i++) {
      newStart.val = Integer.parseInt(stringBuilder.charAt(i) + "");
      if (i == stringBuilder.length() - 1) return newHead;
      newStart.next = new ListNode();
      newStart = newStart.next;
    }
    return newHead;
  }
}