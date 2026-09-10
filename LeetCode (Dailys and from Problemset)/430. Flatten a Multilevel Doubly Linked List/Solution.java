import static java.util.Objects.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {

  class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
  }

  public Node flatten(Node head) {
    Node curr = head;
    while (nonNull(curr)) {
      handleChild(curr, curr.next);
      curr = curr.next;
    }

    return head;
  }

  private void handleChild(Node father, Node next) {
    Node child = father.child;
    if (isNull(child)) return;

    Node prev = father;
    Node curr = child;
    while (nonNull(curr)) {
      handleChild(curr, curr.next);
      prev = curr;
      curr = curr.next;
    }

    father.child = null;
    father.next = child;
    child.prev = father;
    prev.next = next;
    if (nonNull(next)) next.prev = prev;
  }
}