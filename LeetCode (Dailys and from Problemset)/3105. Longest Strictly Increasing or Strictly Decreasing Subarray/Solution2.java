class Solution {
  public int longestMonotonicSubarray(int[] nums) {
    int n = nums.length;
    int inclong = 1;
    int declong = 1;
    int maxlong = 1;

    for (int i = 0; i < n - 1; i++) {
      if (nums[i + 1] > nums[i]) {
        inclong++;
        declong = 1;
      } else if (nums[i + 1] < nums[i]) {
        declong++;
        inclong = 1;
      } else {
        declong = 1;
        inclong = 1;
      }
      maxlong = Math.max(maxlong, Math.max(inclong, declong));
    }
    return maxlong;

  }
}