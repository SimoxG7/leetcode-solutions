class Solution {
  public int minFallingPathSum(int[][] grid) {
    int n = grid.length;
    int first_min = Integer.MAX_VALUE, second_min = Integer.MAX_VALUE;
    int first_index = -1, second_index = -1;
    for (int i = 0; i < n; i++) {
      if (i != 0) {
        for (int j = 0; j < n; j++) {
          if (j != first_index)
            grid[i][j] += first_min;
          else
            grid[i][j] += second_min;
        }
      }
      first_min = Integer.MAX_VALUE;
      second_min = Integer.MAX_VALUE;
      for (int j = 0; j < n; j++) {
        if (grid[i][j] < first_min) {
          second_min = first_min;
          first_min = grid[i][j];
          first_index = j;
        } else if (grid[i][j] < second_min) {
          second_min = grid[i][j];
          second_index = j;
        }
      }
    }
    return Math.min(first_min, second_min);
  }
}
