class Solution {
  public int[][] construct2DArray(int[] original, int m, int n) {
    int len = original.length;
    if (len != m * n) return new int[0][0];
    int[][] res = new int[m][n];
    int counter = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        res[i][j] = original[counter++];
      }
    }
    return res;
  }
}