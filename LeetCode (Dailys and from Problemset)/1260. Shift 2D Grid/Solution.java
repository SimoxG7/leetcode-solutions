import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    int flat = m * n;

    k = k % flat;

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentRow = new ArrayList<>();

    for (int i = 0; i < flat; i++) {
      int oldIndex = (i - k + flat) % flat;
      int row = oldIndex / n;
      int col = oldIndex % n;

      currentRow.add(grid[row][col]);

      if (currentRow.size() == n) {
        result.add(currentRow);
        currentRow = new ArrayList<>();
      }
    }

    return result;
  }
}