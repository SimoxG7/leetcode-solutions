class Solution {
  private int n;
  private int m;
  private static final int[][][] STREETS = {
      {},
      { { 0, -1 }, { 0, +1 } },
      { { -1, 0 }, { +1, 0 } },
      { { 0, -1 }, { +1, 0 } },
      { { 0, +1 }, { +1, 0 } },
      { { 0, -1 }, { -1, 0 } },
      { { 0, +1 }, { -1, 0 } },
  };
  boolean[][] visited;

  public boolean hasValidPath(int[][] grid) {
    n = grid.length;
    m = grid[0].length;
    visited = new boolean[n][m];
    return dfs(grid, 0, 0);
  }

  public boolean dfs(int[][] grid, int row, int col) {
    if (row == n - 1 && col == m - 1)
      return true;
    visited[row][col] = true;
    for (int[] a : STREETS[grid[row][col]]) {
      int nr = row + a[0];
      int nc = col + a[1];
      if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc])
        continue;
      for (int[] x : STREETS[grid[nr][nc]]) {
        if (nr + x[0] == row && nc + x[1] == col) {
          if (dfs(grid, nr, nc))
            return true;
        }

      }
    }
    return false;
  }
}