class Solution {
  public boolean isTrionic(int[] nums) {
    int n = nums.length;
    if (n < 3)
      return false;
    boolean p = false;
    boolean q = false;
    if (nums[1] <= nums[0])
      return false;

    for (int i = 1; i < n; i++) {
      if (nums[i] == nums[i - 1])
        return false;

      if (!p && !q) {
        if (nums[i] < nums[i - 1]) {
          p = true;
        }
      } else if (p && !q) {
        if (nums[i] > nums[i - 1]) {
          q = true;
        }
      } else {
        if (nums[i] < nums[i - 1]) {
          return false;
        }
      }
    }

    return p && q;
  }
}