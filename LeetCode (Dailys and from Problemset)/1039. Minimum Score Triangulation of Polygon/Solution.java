class Solution {
  public int minScoreTriangulation(int[] values) {
    int n = values.length;
    int[][] dp = new int[n][n];

    // Process polygons of increasing lengths
    for (int length = 3; length <= n; length++) {
      for (int i = 0; i + length - 1 < n; i++) {
        int j = i + length - 1;
        dp[i][j] = Integer.MAX_VALUE;

        // Try all possible third vertices to form triangle (i,k,j)
        for (int k = i + 1; k < j; k++) {
          int cost = dp[i][k] + dp[k][j] + values[i] * values[k] * values[j];
          dp[i][j] = Math.min(dp[i][j], cost);
        }
      }
    }

    return dp[0][n - 1];
  }
}