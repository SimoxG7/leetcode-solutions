class Solution {
  public int[][] largestLocal(int[][] grid) {
    int n = grid.length;
    int newSize = n - 2;
    int[][] res = new int[newSize][newSize];
    for (int i = 1; i < n - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        res[i-1][j-1] = getMax(i, j, grid);
      }
    }
    return res;
  }

  private int getMax(int x, int y, int[][] grid) {
    int max = 0;
    for (int i = x - 1; i < x + 2; i++) {
      for (int j = y - 1; j < y + 2; j++) {
        max = Math.max(max, grid[i][j]);
      }
    }
    return max;
  }
}