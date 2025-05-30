class Solution {
  public int longestIncreasingPath(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] dp = new int[m][n];
    int maxPath = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        maxPath = Math.max(maxPath, dfs(matrix, dp, i, j));
      }
    }
    return maxPath;
  }

  private int dfs(int[][] matrix, int[][] dp, int i, int j) {
    if (dp[i][j] != 0) {
      return dp[i][j];
    }
    int m = matrix.length, n = matrix[0].length;
    int maxLength = 1; // The path length starts with the current cell
    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    for (int[] dir : directions) {
      int ni = i + dir[0], nj = j + dir[1];
      if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] > matrix[i][j]) {
        maxLength = Math.max(maxLength, 1 + dfs(matrix, dp, ni, nj));
      }
    }

    dp[i][j] = maxLength; // Store the result in dp array
    return maxLength;
  }
}