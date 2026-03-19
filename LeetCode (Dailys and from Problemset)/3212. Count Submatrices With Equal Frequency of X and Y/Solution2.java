class Solution {
  public int numberOfSubmatrices(char[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] prefixSum = new int[m + 1][n + 1];
    boolean[][] xPresent = new boolean[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        int cellValue = 0;
        char cellChar = grid[i - 1][j - 1];
        xPresent[i][j] = xPresent[i - 1][j] || xPresent[i][j - 1] || cellChar == 'X';
        if (cellChar == 'X') cellValue = 1;
        else if (cellChar == 'Y') cellValue = -1;
        prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + cellValue;
      }
    }

    int count = 0;

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (xPresent[i][j] && prefixSum[i][j] == 0) count++;
      }
    }
    return count;
  }
}