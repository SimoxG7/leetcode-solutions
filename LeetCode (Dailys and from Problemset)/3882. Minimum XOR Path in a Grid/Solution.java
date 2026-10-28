class Solution {
  private int res;
  private boolean[][][] dp;

  public int minCost(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    res = Integer.MAX_VALUE;
    dp = new boolean[m][n][1024];

    dfs(grid, 0, 0, 0, m, n);

    return res;
  }

  private void dfs(int[][] grid, int i, int j, int xor, int m, int n) {
    xor ^= grid[i][j];

    if (res == 0)
      return;

    // Already visited this state
    if (dp[i][j][xor])
      return;

    dp[i][j][xor] = true;

    // Destination reached
    if (i == m - 1 && j == n - 1) {
      res = Math.min(res, xor);
      return;
    }

    // Move down
    if (i + 1 < m)
      dfs(grid, i + 1, j, xor, m, n);

    // Move right
    if (j + 1 < n)
      dfs(grid, i, j + 1, xor, m, n);
  }
}