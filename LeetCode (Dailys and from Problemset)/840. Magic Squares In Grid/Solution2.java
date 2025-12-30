class Solution {

  private boolean isValid(int[][] grid, int r, int c, int re, int ce) {
    int[] freq = new int[9];
    for (int i = r; i <= re; i++) {
      for (int j = c; j <= ce; j++) {
        if (grid[i][j] < 10 && grid[i][j] > 0) {
          freq[grid[i][j] - 1]++;
        }
      }
    }

    for (int f : freq) {
      if (f == 0)
        return false;
    }

    int sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];

    for (int i = r; i <= re; i++) {
      int s = grid[i][c] + grid[i][c + 1] + grid[i][c + 2];
      if (s != sum) {
        return false;
      }
    }

    for (int i = c; i <= ce; i++) {
      int s = grid[r][i] + grid[r + 1][i] + grid[r + 2][i];
      if (s != sum) {
        return false;
      }
    }

    if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != sum ||
        grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != sum) {
      return false;
    }

    return true;
  }

  public int numMagicSquaresInside(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    int count = 0;
    for (int i = 0; i < n - 2; i++) {
      for (int j = 0; j < m - 2; j++) {
        if (isValid(grid, i, j, i + 2, j + 2)) {
          count++;
        }
      }
    }
    return count;
  }
}