import java.util.Arrays;

class Solution {
  public int countUnguarded(int rows, int cols, int[][] guards, int[][] walls) {
    int[][] grid = new int[rows][cols];
    for (int[] row : grid) {
      Arrays.fill(row, -1);
    }

    int totalCells = rows * cols;
    int blockedCells = 0;

    for (int[] guard : guards) {
      int r = guard[0], c = guard[1];
      blockedCells++;
      grid[r][c] = 1;
    }

    for (int[] wall : walls) {
      int r = wall[0], c = wall[1];
      blockedCells++;
      grid[r][c] = 0;
    }

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == 1) {
          blockedCells += markRight(rows, cols, r, c + 1, grid);
          blockedCells += markLeft(rows, cols, r, c - 1, grid);
          blockedCells += markDown(rows, cols, r + 1, c, grid);
          blockedCells += markUp(rows, cols, r - 1, c, grid);
        }
      }
    }

    return totalCells - blockedCells;
  }

  public int markRight(int rows, int cols, int r, int c, int[][] grid) {
    if (c == cols || grid[r][c] == 0 || grid[r][c] == 1)
      return 0;
    if (grid[r][c] == 2)
      return markRight(rows, cols, r, c + 1, grid);
    grid[r][c] = 2;
    return 1 + markRight(rows, cols, r, c + 1, grid);
  }

  public int markLeft(int rows, int cols, int r, int c, int[][] grid) {
    if (c == -1 || grid[r][c] == 0 || grid[r][c] == 1)
      return 0;
    if (grid[r][c] == 2)
      return markLeft(rows, cols, r, c - 1, grid);
    grid[r][c] = 2;
    return 1 + markLeft(rows, cols, r, c - 1, grid);
  }

  public int markDown(int rows, int cols, int r, int c, int[][] grid) {
    if (r == rows || grid[r][c] == 0 || grid[r][c] == 1)
      return 0;
    if (grid[r][c] == 2)
      return markDown(rows, cols, r + 1, c, grid);
    grid[r][c] = 2;
    return 1 + markDown(rows, cols, r + 1, c, grid);
  }

  public int markUp(int rows, int cols, int r, int c, int[][] grid) {
    if (r == -1 || grid[r][c] == 0 || grid[r][c] == 1)
      return 0;
    if (grid[r][c] == 2)
      return markUp(rows, cols, r - 1, c, grid);
    grid[r][c] = 2;
    return 1 + markUp(rows, cols, r - 1, c, grid);
  }
}