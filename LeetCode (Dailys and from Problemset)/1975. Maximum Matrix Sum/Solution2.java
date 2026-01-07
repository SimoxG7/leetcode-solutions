class Solution {
  public long maxMatrixSum(int[][] matrix) {
    long maxSum = 0;
    int negCnt = 0;
    int minNegVal = Integer.MAX_VALUE;

    int m = matrix.length;
    int n = matrix[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int val = Math.abs(matrix[i][j]);
        minNegVal = Math.min(minNegVal, val);
        maxSum += val;
        if (matrix[i][j] < 0) {
          negCnt++;
        }
      }
    }

    if (negCnt % 2 == 0) {
      return maxSum;
    } else {
      return maxSum - 2 * minNegVal;
    }

  }
}