class Solution {
  int row = 0;
  int col = 0;
  int[][] cells;
  public int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public int latestDayToCross(int row, int col, int[][] cells) {
    this.cells = cells;
    this.row = row;
    this.col = col;

    int left = 1, right = cells.length;
    int mid;
    while (left < right) {
      mid = right - (right - left) / 2;
      if (canCross(mid)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  public boolean canCross(int day) {
    int[][] grid = new int[row][col];
    for (int i = 0; i < day; i++) {
      grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
    }

    for (int i = 0; i < col; i++) {
      if (grid[0][i] == 0 && dfs(grid, 0, i)) {
        return true;
      }
    }
    return false;
  }

  public boolean dfs(int[][] grid, int r, int c) {
    if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] != 0)
      return false;

    if (r == row - 1)
      return true;
    grid[r][c] = -1;
    for (int[] direction : directions) {
      int i = r + direction[0];
      int j = c + direction[1];
      if (dfs(grid, i, j))
        return true;
    }
    return false;
  }
}