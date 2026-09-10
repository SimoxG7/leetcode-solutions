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
import static java.util.Objects.isNull;

class Solution {

  class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
      this.val = val;
    }

    public Node(int val, List<Node> children) {
      this.val = val;
      this.children = children;
    }
  }

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> accumulator = new ArrayList<>();
    
    if (isNull(root))
      return accumulator;

    List<Node> currentLevelNodes = new ArrayList<>();
    currentLevelNodes.add(root);
    
    return levelOrderTraversal(currentLevelNodes, accumulator);
  }

  private List<List<Integer>> levelOrderTraversal(List<Node> currentLevelNodes, List<List<Integer>> accumulator) {

    while (!currentLevelNodes.isEmpty()) {

      List<Integer> levelAccumulator = new ArrayList<>();
      List<Node> nextLevelNodes = new ArrayList<>();
      
      for (Node node : currentLevelNodes) {
        levelAccumulator.add(node.val);
        List<Node> children = node.children;
        if (isNull(children)) continue;
        nextLevelNodes.addAll(children);
      }

      accumulator.add(levelAccumulator);
      currentLevelNodes = nextLevelNodes;
    }

    return accumulator;
  }
}