class Solution {
  public int maximumDifference(int[] nums) {
    int n = nums.length;
    int maxDiff = -1;
    int i = 0;
    for (int j = 1; j < n; j++) {
      if (j > i && nums[j] > nums[i]) maxDiff = Math.max(maxDiff, nums[j] - nums[i]);
      else i = j;
    }
    return maxDiff;
  }
}