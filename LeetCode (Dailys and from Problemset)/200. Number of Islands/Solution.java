import java.util.HashSet;
import java.util.Set;

class Solution {
  public int numIslands(char[][] grid) {
    int res = 0;
    Set<Integer> checked = new HashSet<>();
    int rows = grid.length;
    int cols = grid[0].length;
    int gridSize = rows * cols;
    for (int i = 0; i < gridSize; i++) {
      int row = i / cols;
      int col = i % cols;
      if (dfs(grid, checked, row, col, rows, cols)) {
        res++;
      }
    }
    return res;
  }

  public boolean dfs(char[][] grid, Set<Integer> checked, int row, int col, int rows, int cols) {
    char curr = grid[row][col];
    int index = row * cols + col;
    if (!checked.contains(index) && curr == '1') {
      checked.add(index);
      if (col - 1 >= 0) {
        dfs(grid, checked, row, col - 1, rows, cols);
      }
      if (row - 1 >= 0) {
        dfs(grid, checked, row - 1, col, rows, cols);
      }
      if (row + 1 < rows) {
        dfs(grid, checked, row + 1, col, rows, cols);
      }
      if (col + 1 < cols) {
        dfs(grid, checked, row, col + 1, rows, cols);
      }
      return true;
    } else {
      checked.add(index);
      return false;
    }
  }
}