public class Solution {
  public int getMaximumGold(int[][] grid) {
    int len = grid.length;
    int br = grid[0].length;
    int[] max = new int[1]; 

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < br; j++) {
        traveller(grid, i, j, 0, max);
      }
    }
    return max[0];
  }

  private void traveller(int[][] grid, int i, int j, int money, int[] max) {
    int len = grid.length;
    int br = grid[0].length;

    if (i >= len || i < 0 || j >= br || j < 0 || grid[i][j] == 0) {
      if (money > max[0])
        max[0] = money;
      return;
    }

    int temp = grid[i][j];
    grid[i][j] = 0;

    traveller(grid, i + 1, j, money + temp, max);
    traveller(grid, i - 1, j, money + temp, max);
    traveller(grid, i, j + 1, money + temp, max);
    traveller(grid, i, j - 1, money + temp, max);

    grid[i][j] = temp;
  }
}
