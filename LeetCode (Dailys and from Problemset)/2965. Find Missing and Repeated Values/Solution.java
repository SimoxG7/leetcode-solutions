class Solution {
  public int[] findMissingAndRepeatedValues(int[][] grid) {
    int dup = -1, missing = -1;
    int n = grid.length;
    int nSquared = n * n;
    boolean[] presentArr = new boolean[nSquared];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int num = grid[i][j];
        if (presentArr[num - 1]) dup = num;
        presentArr[num - 1] = true;
      }
    }

    for (int i = 0; i < nSquared; i++) {
      if (!presentArr[i]) {
        missing = i + 1;
        break;
      }
    }

    int[] res = {dup, missing};
    return res;
  }
}