class MyCalendar {

  private class Node {
    int start, end;
    Node left, right;

    Node(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  Node root;

  public boolean book(int start, int end) {
    if (root == null) {
      root = new Node(start, end);
      return true;
    }
    Node curr = root;
    while (curr != null) {
      if (end <= curr.start) {
        if (curr.left == null) {
          curr.left = new Node(start, end);
          return true;
        } else
          curr = curr.left;
      } else if (start >= curr.end) {
        if (curr.right == null) {
          curr.right = new Node(start, end);
          return true;
        } else
          curr = curr.right;
      } else
        return false;
    }
    return false;
  }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */