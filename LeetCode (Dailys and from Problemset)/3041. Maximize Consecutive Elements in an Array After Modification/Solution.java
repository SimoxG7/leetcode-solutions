import java.util.Arrays;

class Solution {
  public int maxSelectedElements(int[] nums) {
    Arrays.sort(nums);
    int res = 1;
    int[] dp = new int[nums[nums.length - 1] + 3];
    for (int i : nums) {
      dp[i + 1] = Math.max(dp[i + 1], dp[i] + 1);
      dp[i] = Math.max(dp[i], dp[i - 1] + 1);
      res = Math.max(res, Math.max(dp[i], dp[i + 1]));
    }
    return res;
  }
}