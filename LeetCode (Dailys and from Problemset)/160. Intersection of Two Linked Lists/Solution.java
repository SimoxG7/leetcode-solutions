import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class Solution {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    List<ListNode> lst = new ArrayList<>();
    ListNode copyA = headA;
    while (copyA != null) {
      lst.add(copyA);
      copyA = copyA.next;
    }
    ListNode copyB = headB;
    while (copyB != null) {
      if (lst.contains(copyB)) return copyB;
      copyB = copyB.next;
    }
    return null;
  }
}