class Solution {
  public long gridGame(int[][] grid) {
    int n = grid[0].length;

    long[] topPrefix = new long[n];
    long[] bottomPrefix = new long[n];

    topPrefix[0] = grid[0][0];
    for (int i = 1; i < n; i++) {
      topPrefix[i] = topPrefix[i - 1] + grid[0][i];
    }

    bottomPrefix[0] = grid[1][0];
    for (int i = 1; i < n; i++) {
      bottomPrefix[i] = bottomPrefix[i - 1] + grid[1][i];
    }

    long minPointsForSecondRobot = Long.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      long pointsTop = i == n - 1 ? 0 : topPrefix[n - 1] - topPrefix[i];
      long pointsBottom = i == 0 ? 0 : bottomPrefix[i - 1];
      long secondRobotPoints = Math.max(pointsTop, pointsBottom);
      minPointsForSecondRobot = Math.min(minPointsForSecondRobot, secondRobotPoints);
    }

    return minPointsForSecondRobot;
  }
}