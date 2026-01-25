import java.util.Arrays;

class Solution {
  public int minimumDifference(int[] nums, int k) {
    Arrays.sort(nums);
    int minDiffBetweenMaxMin = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length - k + 1; i++) {
      minDiffBetweenMaxMin = Math.min(minDiffBetweenMaxMin, nums[i + k - 1] - nums[i]);
    }
    return minDiffBetweenMaxMin;
  }
}