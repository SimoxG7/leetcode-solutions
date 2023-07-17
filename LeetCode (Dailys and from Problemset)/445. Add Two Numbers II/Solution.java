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

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    String n1 = "";
    String n2 = ""; 
    while (l1 != null) {
      n1 += l1.val;
      l1 = l1.next;
    }
    while (l2 != null) {
      n2 += l2.val;
      l2 = l2.next;
    }
    if (n1.isBlank()) n1 = "0";
    if (n2.isBlank()) n2 = "0";
    String sum;
    int difflen = n1.length() - n2.length();
    int max = Math.max(n1.length(), n2.length());
    if (difflen < 0) {
      String t = "";
      for (int i = 0; i < -difflen; i++) {
        t += "0";
      }
      n1 = t + n1;
    } else {
      String t = "";
      for (int i = 0; i < difflen; i++) {
        t += "0";
      }
      n2 = t + n2;
    }
    String added = "";
    int riporto = 0;
    for (int i = max-1; i >= 0; i--) {
      int curr = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "") + riporto;
      riporto = 0;
      if (curr > 9) {
        riporto = 1;
        curr -= 10;
      } 
      added = curr + added;
    }
    if (riporto != 0) {
      added = riporto + added;
    }
    ListNode res = new ListNode();
    ListNode start = res;
    for (int i = 0; i < added.length(); i++) {
      ListNode temp = new ListNode(Integer.parseInt(added.charAt(i) + ""), null);
      res.next = temp;
      res = temp;
    }
    return start.next;
  }
}