class Solution {

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

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    //inorder: left, mid, right
    //postorder: left, right, mid
    return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
  }

  private TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
    if (instart > inend || poststart > postend) {
      return null;
    }

    int rootval = postorder[postend];
    TreeNode root = new TreeNode(rootval);
    int rootindex = 0;

    for (int i = instart; i <= inend; i++) {
      if (inorder[i] == rootval) {
        rootindex = i;
        break;
      }
    }

    root.left = helper(inorder, instart, rootindex-1, postorder, poststart, poststart + rootindex - instart - 1);
    root.right = helper(inorder, rootindex+1, inend, postorder, postend - inend + rootindex, postend-1);
    
    return root;
  }
}