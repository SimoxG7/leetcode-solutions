class Solution {
  public int findMaxFish(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int max = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] != 0) max = Math.max(max, dfs(grid, i, j, m, n));
      }
    }
    return max;
  }

  private int dfs(int grid[][], int i, int j, int m, int n) {
    if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return 0;
    int sum = grid[i][j];
    grid[i][j] = 0;
    sum += dfs(grid, i + 1, j, m, n);
    sum += dfs(grid, i, j + 1, m, n);
    sum += dfs(grid, i, j - 1, m, n);
    sum += dfs(grid, i - 1, j, m, n);
    return sum;
  }
}