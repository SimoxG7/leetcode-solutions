import java.util.Arrays;

class Solution {
  public int rob(int[] nums) {
    if (nums.length == 1)
      return nums[0];
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    int firstTake = count(nums, 0, nums.length - 1, dp);
    Arrays.fill(dp, -1);
    int firstNotTake = count(nums, 1, nums.length, dp);
    return Math.max(firstTake, firstNotTake);
  }

  int count(int[] arr, int i, int n, int[] dp) {
    if (i == n - 1)
      return dp[i] = arr[i];
    if (i >= n)
      return 0;
    if (dp[i] != -1)
      return dp[i];
    int take = arr[i] + count(arr, i + 2, n, dp);
    int nottake = count(arr, i + 1, n, dp);
    return dp[i] = Math.max(take, nottake);
  }
}