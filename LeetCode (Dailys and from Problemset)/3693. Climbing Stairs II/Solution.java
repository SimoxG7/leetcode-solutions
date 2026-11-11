import java.util.Arrays;

class Solution {
  public int climbStairs(int n, int[] costs) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      int idx = i - 1;
      while (idx >= Math.max(0, i - 3)) {
        dp[i] = Math.min(dp[i], dp[idx] + getCost(costs[i - 1], i, idx));
        idx--;
      }
    }

    return dp[n];
  }

  private int getCost(int jCost, int i, int j) {
    return jCost + (j - i) * (j - i);
  }
}