import java.util.ArrayList;
import java.util.List;

class BSTIterator {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  List<Integer> lst;
  int curr;
  int len;

  public BSTIterator(TreeNode root) {
    lst = new ArrayList<>();
    inOrder(root);
    curr = 0;
    len = lst.size();
  }

  public void inOrder(TreeNode root) {
    if (root == null) return;
    inOrder(root.left);
    lst.add(root.val);
    inOrder(root.right);
  }

  public int next() {
    return lst.get(curr++);
  }

  public boolean hasNext() {
    return curr < len;
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */