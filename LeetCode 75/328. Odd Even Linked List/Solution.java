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

  public ListNode oddEvenList(ListNode head) {
    ListNode evenstart = null, evenend = null, oddstart = null, oddend = null;
    // es->even start ee->even end os->odd start oe->odd end
    int count = 0;
    ListNode curr = head;
    while (curr != null) {
      count++;
      if (count % 2 != 0) {
        if (oddstart == null) {
          oddstart = oddend = curr;
        } else {
          oddend.next = curr;
          oddend = oddend.next;
        }
      } else {
        if (evenstart == null) {
          evenstart = evenend = curr;
        } else {
          evenend.next = curr;
          evenend = evenend.next;
        }
      }
      curr = curr.next;
    }
    if (oddstart == null || evenstart == null)
      return head;
    oddend.next = evenstart;
    evenend.next = null;
    return oddstart;
  }
}