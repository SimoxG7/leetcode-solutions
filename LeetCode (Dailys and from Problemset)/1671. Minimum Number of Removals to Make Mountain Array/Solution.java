class Solution {
  public int minimumMountainRemovals(int[] nums) {
    int[] dplis = new int[nums.length];
    int[] dplds = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      dplis[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dplis[i] = Math.max(dplis[i], dplis[j] + 1);
        }
      }
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      dplds[i] = 1;
      for (int j = nums.length - 1; j > i; j--) {
        if (nums[i] > nums[j]) {
          dplds[i] = Math.max(dplds[i], dplds[j] + 1);
        }
      }
    }
    int max = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (dplis[i] > 1 && dplds[i] > 1) {
        max = Math.max(max, dplis[i] + dplds[i] - 1);
      }
    }
    return nums.length - max;
  }
}