class Solution {
  public boolean checkStraightLine(int[][] coordinates) {
    int xdiff = coordinates[0][0] - coordinates[1][0];
    int ydiff = coordinates[0][1] - coordinates[1][1];
    for (int i = 1; i < coordinates.length; i++) {
      int x = coordinates[i][0] - coordinates[i-1][0];
      int y = coordinates[i][1] - coordinates[i-1][1];
      if (x * ydiff != y * xdiff) return false;
    }
    return true;
  }
}