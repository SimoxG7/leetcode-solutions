class Solution {

  int[][] dp;
  int[] di = { 0, 0, -1, 1 };
  int[] dj = { -1, 1, 0, 0 };
  int mod = 1000000007;

  public int countPaths(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    dp = new int[n][m];
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        ans = (ans + dfs(grid, i, j, -1)) % mod;
      }
    }
    return ans;
  }

  public int dfs(int[][] grid, int i, int j, int prev) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] <= prev) {
      return 0;
    }
    if (dp[i][j] != 0) {
      return dp[i][j];
    }
    dp[i][j] = 1;
    for (int k = 0; k < 4; k++) {
      dp[i][j] += dfs(grid, i + di[k], j + dj[k], grid[i][j]);
      dp[i][j] = dp[i][j] % mod;
    }
    return dp[i][j] % mod;
  }
}