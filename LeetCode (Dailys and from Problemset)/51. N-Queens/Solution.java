import java.util.ArrayList;
import java.util.List;

class Solution {

  private boolean isValid(int[][] grid, int x, int y) {
    // row
    for (int i = 0; i < grid.length; i++) {
      if (grid[x][i] == 1) return false;
    }

    // column
    for (int i = 0; i < grid.length; i++) {
      if (grid[i][y] == 1) return false;
    }

    // left diagonal 
    for (int i = 0; i < grid.length; i++) {
      if (x + i < grid.length && y + i < grid.length) {
        if (grid[x + i][y + i] == 1) return false;
      }
    }
    for (int i = 0; i < grid.length; i++) {
      if (x - i >= 0 && y - i >= 0) {
        if (grid[x - i][y - i] == 1) return false;
      }
    }

    // right diagonal
    for (int i = 0; i < grid.length; i++) {
      if (x + i < grid.length && y - i >= 0) {
        if (grid[x + i][y - i] == 1) return false;
      }
    }
    for (int i = 0; i < grid.length; i++) {
      if (x - i >= 0 && y + i < grid.length) {
        if (grid[x - i][y + i] == 1) return false;
      }
    }
    return true;
  }

  private List<String> parseMatrix(int[][] grid) {
    List<String> res = new ArrayList<>();
    for (int i = 0; i < grid.length; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < grid.length; j++) {
        if (grid[i][j] == 1) {
          sb.append("Q");
        } else {
          sb.append(".");
        }
      }
      res.add(sb.toString());
    }
    return res;
  }

  private void backtrack(int[][] grid, int x, int y, int qCount, int n, List<List<String>> res) {
    if (qCount == n) {
      List<String> combination = parseMatrix(grid);
      res.add(combination);
      return;
    }

    if (x >= n) { return; }

    int newX = -1;
    int newY = -1;

    if (y == n - 1) {
      newX = x + 1;
      newY = 0;
    } else {
      newX = x;
      newY = y + 1;
    }

    if (isValid(grid, x, y)) {
      grid[x][y] = 1;
      backtrack(grid, newX, newY, qCount + 1, n, res);
      grid[x][y] = 0;
    }
    backtrack(grid, newX, newY, qCount, n, res);

  }

  public List<List<String>> solveNQueens(int n) {
    int[][] grid = new int[n][n];
    List<List<String>> res = new ArrayList<>();
    backtrack(grid, 0, 0, 0, n, res);
    return res;
  }
}