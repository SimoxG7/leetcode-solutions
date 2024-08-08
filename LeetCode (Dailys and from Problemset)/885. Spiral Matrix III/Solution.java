class Solution {
  int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

  public int[][] spiralMatrixIII(int rows, int cols,
      int rStart, int cStart) {

    int[][] res = new int[rows * cols][2];
    int idx = 0;
    res[idx++] = new int[] { rStart, cStart };

    int dirIndex = 0, len = 0;
    while (idx < rows * cols) {
      if (dirIndex == 0 || dirIndex == 2) {
        len++;
      }

      for (int i = 0; i < len; i++) {
        rStart += dir[dirIndex][0];
        cStart += dir[dirIndex][1];
        if (rStart >= 0 && rStart < rows
            && cStart >= 0 && cStart < cols) {
          res[idx++] = new int[] { rStart, cStart };
        }
      }
      dirIndex = (dirIndex + 1) % 4;
    }
    return res;
  }
}