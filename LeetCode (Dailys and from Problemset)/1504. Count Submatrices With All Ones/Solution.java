class Solution {
  public int numSubmat(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int count = 0;
    int[] height = new int[cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == 1) {
          height[j]++;
        } else {
          height[j] = 0;
        }
        int minHeight = height[j];
        for (int k = j; k >= 0; k--) {
          if (matrix[i][k] == 0) {
            break;
          }
          minHeight = Math.min(minHeight, height[k]);
          count += minHeight;
        }
      }
    }
    return count;
  }
}