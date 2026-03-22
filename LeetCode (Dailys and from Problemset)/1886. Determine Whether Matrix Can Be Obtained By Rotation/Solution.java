class Solution {
  public boolean findRotation(int[][] mat, int[][] target) {
    boolean degrees0 = true, degrees90 = true, degrees180 = true, degrees270 = true;
    int len = mat.length;

    for (int row = 0; row < len; row++) {
      for (int col = 0; col < len; col++) {
        int curr = mat[row][col];

        if (degrees0 && curr != target[row][col])
          degrees0 = false;
        if (degrees90 && curr != target[col][len - 1 - row])
          degrees90 = false;
        if (degrees180 && curr != target[len - 1 - row][len - 1 - col])
          degrees180 = false;
        if (degrees270 && curr != target[len - 1 - col][row])
          degrees270 = false;

        if (!degrees0 && !degrees180 && !degrees90 && !degrees270)
          return false;
      }
    }
    return true;
  }
}