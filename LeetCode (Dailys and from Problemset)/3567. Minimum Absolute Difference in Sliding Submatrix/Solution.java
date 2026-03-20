import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public int[][] minAbsDiff(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] res = new int[m - k + 1][n - k + 1];

    for (int i = 0; i <= m - k; i++) {
      for (int j = 0; j <= n - k; j++) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int r = i; r < i + k; r++) {
          for (int c = j; c < j + k; c++) {
            if (!set.contains(grid[r][c])) {
              set.add(grid[r][c]);
              list.add(grid[r][c]);
            }
          }
        }

        Collections.sort(list);
        int minDiff = Integer.MAX_VALUE;
        for (int x = 0; x < list.size() - 1; x++) {
          int diff = Math.abs(list.get(x) - list.get(x + 1));
          minDiff = Math.min(minDiff, diff);
        }

        if (list.size() <= 1)
          minDiff = 0;
        res[i][j] = minDiff;
      }
    }
    return res;
  }
}