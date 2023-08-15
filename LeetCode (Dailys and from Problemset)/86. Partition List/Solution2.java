class Solution2 {

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

  public ListNode partition(ListNode head, int x) {
    if (head == null) return null;
    ListNode greater = null, greaterStart = null;
    ListNode lower = null, lowerStart = null;
    while (head != null) {
      int currval = head.val;
      if (currval < x) {
        if (lowerStart == null) {
          lowerStart = new ListNode(currval);
          lower = lowerStart;
        } else {
          lower.next = new ListNode(currval);
          lower = lower.next;
        }
      } else {
        if (greaterStart == null) {
          greaterStart = new ListNode(currval);
          greater = greaterStart;
        } else {
          greater.next = new ListNode(currval);
          greater = greater.next;
        }
      }
      head = head.next;
    }
    if (lower != null) {
      lower.next = greaterStart;
      return lowerStart;
    } 
    return greaterStart;
  }
}