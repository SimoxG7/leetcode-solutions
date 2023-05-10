class Solution2 {
  public int[][] generateMatrix(int n) {
    int[][] res = new int[n][n];
    int up = 0, left = 0, down = n - 1, right = n - 1;
    int count = 1;
    while (up <= down && left <= right) {
      for (int i = left; i <= right; i++) {
        res[up][i] = count;
        count++;
      }
      up++;

      for (int i = up; i <= down; i++) {
        res[i][right] = count;
        count++;
      }
      right--;

      if (up <= down) {
        for (int i = right; i >= left; i--) {
          res[down][i] = count;
          count++;
        }
        down--;
      }
      
      if (left <= right) {
        for (int i = down; i >= up; i--) {
          res[i][left] = count;
          count++;
        }
        left++;
      }
    }
    return res;
  }
}