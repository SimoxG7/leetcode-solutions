class Solution {
  public int minDays(int[][] grid) {
    int m = grid.length, n = grid[0].length;

    if (!isConnected(grid, m, n)) {
      return 0;
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          grid[i][j] = 0;
          if (!isConnected(grid, m, n)) {
            return 1;
          }
          grid[i][j] = 1;
        }
      }
    }

    return 2;
  }

  private boolean isConnected(int[][] grid, int m, int n) {
    boolean[][] visited = new boolean[m][n];
    int[] start = findFirstLand(grid, m, n);

    if (start == null) {
      return false;
    }

    dfs(grid, visited, start[0], start[1], m, n);

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  private void dfs(int[][] grid, boolean[][] visited, int x, int y, int m, int n) {
    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) {
      return;
    }
    visited[x][y] = true;
    dfs(grid, visited, x + 1, y, m, n);
    dfs(grid, visited, x - 1, y, m, n);
    dfs(grid, visited, x, y + 1, m, n);
    dfs(grid, visited, x, y - 1, m, n);
  }

  private int[] findFirstLand(int[][] grid, int m, int n) {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          return new int[] { i, j };
        }
      }
    }
    return null;
  }
}
