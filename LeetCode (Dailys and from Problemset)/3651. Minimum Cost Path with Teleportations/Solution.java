import java.util.Arrays;

class Solution {
  public int minCost(int[][] grid, int k) {
    int n = grid.length, m = grid[0].length;

    int maxValue = 0;
    for (int[] row : grid)
      for (int value : row)
        maxValue = Math.max(maxValue, value);

    int[][] dp = new int[n][m];
    int[] bestValue = new int[maxValue + 1];
    int[] prefix = new int[maxValue + 1];

    Arrays.fill(bestValue, Integer.MAX_VALUE);
    bestValue[grid[n - 1][m - 1]] = 0;

    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        if (i == n - 1 && j == m - 1)
          continue;

        int down = i + 1 < n ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE;
        int right = j + 1 < m ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE;

        dp[i][j] = Math.min(down, right);
        bestValue[grid[i][j]] = Math.min(bestValue[grid[i][j]], dp[i][j]);
      }
    }

    for (int step = 0; step < k; step++) {
      prefix[0] = bestValue[0];
      for (int v = 1; v <= maxValue; v++)
        prefix[v] = Math.min(prefix[v - 1], bestValue[v]);

      for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {
          if (i == n - 1 && j == m - 1)
            continue;

          int walk = Math.min(
              i + 1 < n ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE,
              j + 1 < m ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE);

          dp[i][j] = Math.min(walk, prefix[grid[i][j]]);
          bestValue[grid[i][j]] = Math.min(bestValue[grid[i][j]], dp[i][j]);
        }
      }
    }

    return dp[0][0];
  }
}