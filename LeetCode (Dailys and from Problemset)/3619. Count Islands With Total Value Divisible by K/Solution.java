class Solution {
  private static int m, n;

  public long dfs(int[][] grid, boolean[][] visited, int i, int j) {
    if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] ||
        grid[i][j] == 0)
      return 0;

    visited[i][j] = true;

    return grid[i][j] + dfs(grid, visited, i + 1, j)
        + dfs(grid, visited, i - 1, j)
        + dfs(grid, visited, i, j + 1)
        + dfs(grid, visited, i, j - 1);
  }

  public int countIslands(int[][] grid, int k) {
    m = grid.length;
    n = grid[0].length;

    boolean[][] visited = new boolean[m][n];
    int islands = 0;

    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (grid[i][j] != 0 && !visited[i][j] &&
            dfs(grid, visited, i, j) % k == 0)
          islands++;

    return islands;
  }
}