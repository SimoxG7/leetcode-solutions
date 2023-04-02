class Solution {
  public int deleteAndEarn(int[] nums) {
    int max = 0;
    for (int num : nums)
      max = Math.max(max, num);
    int[] a = new int[max + 1];

    for (int num : nums)
      a[num]++;
    Integer[] dp = new Integer[max + 1];
    return solve(a, 1, dp);
  }

  private int solve(int[] a, int i, Integer[] dp) {
    if (i >= a.length) {
      return 0;
    }
    if (dp[i] != null) {
      return dp[i];
    }
    int pick = a[i] * i + solve(a, i + 2, dp);
    int notPick = solve(a, i + 1, dp);

    return dp[i] = Math.max(pick, notPick);
  }
}
