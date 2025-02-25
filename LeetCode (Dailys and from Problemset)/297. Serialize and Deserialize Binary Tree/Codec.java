import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private final String splitter = ",";
  private final String nullValue = "null";
  private final String leftValue = "[", rightValue = "]";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder(leftValue);
    sb.append(inOrderTraversalToString(root, sb));
    sb.append(rightValue);
    return sb.toString();
  }

  private String inOrderTraversalToString(TreeNode root, StringBuilder sb) {
    if (Objects.isNull(root)) sb.append(nullValue).append(splitter);
    else {
      sb.append(root.val).append(splitter);
      inOrderTraversalToString(root.left, sb);
      inOrderTraversalToString(root.right, sb);
    }
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> nodes = new LinkedList<>(); //or Deque
    nodes.addAll(Arrays.asList(data.substring(1, data.length() - 1).split(splitter)));
    return deserializationRecurse(nodes);
  }

  private TreeNode deserializationRecurse(Queue<String> nodes) {
    String val = nodes.poll();
    if (val.equals(nullValue)) return null;
    else {
      TreeNode node = new TreeNode(Integer.valueOf(val));
      node.left = deserializationRecurse(nodes);
      node.right = deserializationRecurse(nodes);
      return node;
    }
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

// [1,2,null,3,4,5,null,6,null,null,null,7,8]