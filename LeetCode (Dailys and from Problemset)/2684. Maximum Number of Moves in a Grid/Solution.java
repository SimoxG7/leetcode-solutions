import java.util.Arrays;

class Solution {
  int[][] dp;

  public int paths(int[][] grid, int prev, int ind) {
    if (ind == grid[0].length - 1)
      return 0;
    if (dp[prev][ind] != -1)
      return dp[prev][ind];
    int max = 0;
    for (int nr : new int[] { prev - 1, prev, prev + 1 }) {
      if (nr >= 0 && nr < grid.length)
        if (grid[nr][ind + 1] > grid[prev][ind]) {
          max = Math.max(max, 1 + paths(grid, nr, ind + 1));
        }
    }
    return dp[prev][ind] = max;
  }

  public int maxMoves(int[][] grid) {
    int max = 0;
    dp = new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++)
      Arrays.fill(dp[i], -1);
    for (int i = 0; i < grid.length; i++) {
      max = Math.max(max, paths(grid, i, 0));
    }
    return max;
  }
}