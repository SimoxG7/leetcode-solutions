import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
  public int[][] sortMatrix(int[][] grid) {
    int n = grid.length;

    for (int i = 0; i < n; i++) { //sort in non increasing order
      int row = i, col = 0;
      List<Integer> lst = new ArrayList<>();

      while (row < n && col < n) {
        lst.add(grid[row++][col++]);
      }

      Collections.sort(lst, Collections.reverseOrder());
      row = i;
      col = 0;
      int idx = 0;

      while (row < n && col < n) {
        grid[row++][col++] = lst.get(idx++);
      }
    }

    for (int i = 1; i < n; i++) { //sort in non decreasing order
      int row = 0, col = i;
      List<Integer> lst = new ArrayList<>();

      while (row < n && col < n) {
        lst.add(grid[row++][col++]);
      }

      Collections.sort(lst);
      row = 0;
      col = i;
      int idx = 0;

      while (row < n && col < n) {
        grid[row++][col++] = lst.get(idx++);
      }
    }
    return grid;
  }
}