class Solution {
  public boolean canPartitionGrid(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    long[] rowSum = new long[m];
    long[] colSum = new long[n];
    long total = 0;
    
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        rowSum[i] += grid[i][j];
        colSum[j] += grid[i][j];
        total += grid[i][j];
      }
    }

    long currRowSum = 0;
    for (int i = 0; i < m; i++) {
      currRowSum += rowSum[i];
      if (currRowSum == total - currRowSum)
        return true;
    }

    long currColSum = 0;
    for (int i = 0; i < n; i++) {
      currColSum += colSum[i];
      if (currColSum == total - currColSum)
        return true;
    }

    return false;
  }
}