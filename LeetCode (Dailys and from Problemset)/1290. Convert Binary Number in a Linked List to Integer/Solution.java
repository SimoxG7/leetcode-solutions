import java.util.ArrayList;
import java.util.List;
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

  public int getDecimalValue(ListNode head) {
    List<Integer> lst = new ArrayList<>();
    while (Objects.nonNull(head)) {
      lst.add(head.val);
      head = head.next;
    }
    int res = 0;
    int shiftCounter = lst.size();
    for (Integer i : lst) {
      res += i << --shiftCounter;
    }
    return res;
  }
}