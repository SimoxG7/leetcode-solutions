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

  public TreeNode sortedArrayToBST(int[] nums) {
    return create(nums, 0, nums.length - 1);
  }

  private TreeNode create(int nums[], int start, int end) {
    if (start > end) return null;
    int mid = (start + end) / 2; 
    TreeNode root = new TreeNode(nums[mid]);
    root.left = create(nums, start, mid - 1); 
    root.right = create(nums, mid + 1, end); 
    return root;
  }
}