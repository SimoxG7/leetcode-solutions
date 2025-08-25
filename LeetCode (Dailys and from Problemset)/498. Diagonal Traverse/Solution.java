class Solution {
  public int[] findDiagonalOrder(int[][] mat) {
    int m = mat.length, n = mat[0].length;
    int total = m * n;
    int[] acc = new int[total];
    int row = 0, col = 0;
    int cnt = 0;
    boolean goingUp = true;

    while (cnt < total) {
      acc[cnt++] = mat[row][col];

      if (goingUp) { // move up and right
        if (col == n - 1) { // right border
          row++;
          goingUp = false;
        } else if (row == 0) { // top border
          col++;
          goingUp = false;
        } else {
          row--;
          col++;
        }
      } else { //move down and left
        if (row == m - 1) { // bottom border
          col++;
          goingUp = true;
        } else if (col == 0) { // left border
          row++;
          goingUp = true;
        } else {
          row++;
          col--;
        }
      }
    }
    return acc;
  }
}
