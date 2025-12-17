class Solution {
  public long maximumProfit(int[] prices, int k) {
    int n = prices.length;
    if (n == 0 || k == 0)
      return 0;

    long[][][] dp = new long[n][k + 1][3];

    // Initialize DP with very small values
    for (int i = 0; i < n; i++)
      for (int j = 0; j <= k; j++)
        for (int h = 0; h < 3; h++)
          dp[i][j][h] = Long.MIN_VALUE / 2;

    // Base case for day 0
    for (int t = 0; t <= k; t++) {
      dp[0][t][0] = 0;
      if (t > 0) {
        dp[0][t][1] = -prices[0]; // Buy stock
        dp[0][t][2] = prices[0]; // Short sell
      }
    }

    for (int i = 1; i < n; i++) {
      for (int t = 0; t <= k; t++) {
        // State 0: Not holding anything
        dp[i][t][0] = dp[i - 1][t][0];
        if (t <= k)
          dp[i][t][0] = Math.max(dp[i][t][0], Math.max(
              dp[i - 1][t][1] + prices[i], // Sell stock
              dp[i - 1][t][2] - prices[i] // Buy back from short sell
          ));

        // State 1: Holding after buy
        if (t > 0)
          dp[i][t][1] = Math.max(dp[i - 1][t][1], dp[i - 1][t - 1][0] - prices[i]);

        // State 2: Holding after short sell
        if (t > 0)
          dp[i][t][2] = Math.max(dp[i - 1][t][2], dp[i - 1][t - 1][0] + prices[i]);
      }
    }

    long maxProfit = 0;
    for (int t = 0; t <= k; t++) {
      maxProfit = Math.max(maxProfit, dp[n - 1][t][0]);
    }

    return maxProfit;
  }
}