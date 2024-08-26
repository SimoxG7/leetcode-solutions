/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

  class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  };

  public List<Integer> postorder(Node root) {
    List<Integer> accumulator = new ArrayList<>();
    dfs(root, accumulator);
    return accumulator;
  }

  private void dfs(Node root, List<Integer> accumulator) {
    if (Objects.isNull(root)) return;
    if (Objects.nonNull((root.children))) {
      for (Node child : root.children) {
        dfs(child, accumulator);
      }
    }
    accumulator.add(root.val);
  }
}