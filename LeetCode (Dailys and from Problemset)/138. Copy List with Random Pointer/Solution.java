/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;
import java.util.Map;

class Solution {

  class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head) {
    if (head == null)
      return null;

    Map<Node, Node> oldToNew = new HashMap<>();

    Node curr = head;
    while (curr != null) {
      oldToNew.put(curr, new Node(curr.val));
      curr = curr.next;
    }

    curr = head;
    while (curr != null) {
      oldToNew.get(curr).next = oldToNew.get(curr.next);
      oldToNew.get(curr).random = oldToNew.get(curr.random);
      curr = curr.next;
    }

    return oldToNew.get(head);
  }
}