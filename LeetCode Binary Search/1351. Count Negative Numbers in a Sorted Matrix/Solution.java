class Solution {
  public int countNegatives(int[][] grid) {
    int row = 0;
    int cont = 0;
    while (row < grid.length) {
      int right = grid[0].length -1;
      int left = 0;
      while (left <= right) {
        int mid = (right + left)/2;

        if (grid[row][mid] >= 0) left = mid + 1;
        else right = mid-1;
      }
      cont += grid[0].length - right - 1; 
      row++;
    }
    return cont;
  }
}