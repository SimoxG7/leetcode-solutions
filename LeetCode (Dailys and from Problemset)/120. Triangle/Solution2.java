import java.util.Arrays;
import java.util.List;

class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int dp[][] = new int[n][n];
    for (int[] row : dp) {
      Arrays.fill(row, Integer.MIN_VALUE);
    }
    return dfs(triangle, 0, 0, dp);
  }

  private int dfs(List<List<Integer>> triangle, int row, int col, int[][] dp) {
    if (row == triangle.size() - 1) {
      return triangle.get(row).get(col);
    }
    if (dp[row][col] != Integer.MIN_VALUE) {
      return dp[row][col];
    }
    int down = dfs(triangle, row + 1, col, dp);
    int diag = dfs(triangle, row + 1, col + 1, dp);
    return dp[row][col] = triangle.get(row).get(col) + Math.min(down, diag);
  }
}