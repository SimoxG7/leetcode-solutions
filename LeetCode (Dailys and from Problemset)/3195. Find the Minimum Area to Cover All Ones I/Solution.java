class Solution {
  public int minimumArea(int[][] grid) {
    int rowMin = Integer.MAX_VALUE;
    int colMin = Integer.MAX_VALUE;
    int rowMax = Integer.MIN_VALUE;
    int colMax = Integer.MIN_VALUE;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          rowMin = Math.min(rowMin, i);
          colMin = Math.min(colMin, j);
          rowMax = Math.max(i, rowMax);
          colMax = Math.max(j, colMax);
        }
      }
    }
    return (rowMax - rowMin + 1) * (colMax - colMin + 1);
  }
}