/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

  public Node connect(Node node) {
    Map<Integer, List<Node>> map = new HashMap<>();
    goDFS(0, node, map);
    for (int key : map.keySet()) {
      List<Node> list = map.get(key);
      for (int i = 1; i < list.size(); i++) {
        list.get(i - 1).next = list.get(i);
      }
    }
    return node;
  }

  private void goDFS(int lvl, Node node, Map<Integer, List<Node>> map) {
    if (node == null)
      return;

    List<Node> list = map.computeIfAbsent(lvl, k -> new ArrayList<>());
    list.add(node);
    lvl++;
    goDFS(lvl, node.left, map);
    goDFS(lvl, node.right, map);
  }
}