class Solution {
  public int countSquares(int[][] matrix) {
    int r = matrix.length, c = matrix[0].length, count = 0;

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (matrix[i][j] == 1) {
          if (i > 0 && j > 0) {
            matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
          }
          count += matrix[i][j];
        }
      }
    }

    return count;
  }
}