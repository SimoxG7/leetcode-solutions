class Solution {
  public int checkRecord(int n) {
    long M = 1000000007;
    // long[x][y][z]
    // x: The current day x.
    // y: 0 - 1 'A' so far.
    // 1 - 1 'A' so far.
    // z: 0 - the current day (day x) is not 'L'.
    // 1 - the current day is 'L', the previous day is not 'L'.
    // 2 - the current day and the previous day are both 'L'. the day before the
    // previous day is not 'L'.
    long[][][] dp = new long[n][2][3]; // day / 'A' / 'L'
    dp[0][0][0] = 1;
    dp[0][1][0] = 1;
    dp[0][0][1] = 1;
    long cnt = 0;
    for (int i = 1; i < n; i++) {
      dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % M;
      dp[i][0][1] = dp[i - 1][0][0];
      dp[i][0][2] = dp[i - 1][0][1];

      dp[i][1][0] = (dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2] + dp[i - 1][0][0] + dp[i - 1][0][1]
          + dp[i - 1][0][2]) % M;
      dp[i][1][1] = dp[i - 1][1][0];
      dp[i][1][2] = dp[i - 1][1][1];
    }
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        cnt = (cnt + dp[n - 1][i][j]) % M;
      }
    }
    return (int) cnt;
  }
}