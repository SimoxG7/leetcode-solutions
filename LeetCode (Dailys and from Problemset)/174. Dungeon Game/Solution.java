import java.util.Arrays;

class Solution {
  public int calculateMinimumHP(int[][] dun) {
    int n = dun.length;
    int m = dun[0].length;
    int[][] dp = new int[n + 1][m + 1];
    Arrays.fill(dp[n], Integer.MAX_VALUE);
    dp[n][m - 1] = 1;
    for (int i = n - 1; i >= 0; i--) {
      dp[i][m] = Integer.MAX_VALUE;
      if (i == n - 1)
        dp[i][m] = 1;
      for (int j = m - 1; j >= 0; j--) {
        int val = Math.min(dp[i + 1][j], dp[i][j + 1]) - dun[i][j];
        dp[i][j] = Math.max(1, val);
      }
    }
    return dp[0][0];
  }
}