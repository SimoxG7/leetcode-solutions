class Solution {
  public int stoneGameV(int[] arr) {
    int n = arr.length;

    int[] prefixSum = new int[n];
    prefixSum[0] = arr[0];
    for (int i = 1; i < n; i++) {
      prefixSum[i] = prefixSum[i - 1] + arr[i];
    }

    int[][] dp = new int[n][n];

    return check(dp, 0, n - 1, prefixSum);
  }

  public int check(int[][] dp, int low, int high, int[] pre) {
    if (low == high)
      return 0;

    if (dp[low][high] != 0)
      return dp[low][high];

    int res = 0;

    for (int i = low; i < high; i++) {
      int left = (low == 0) ? pre[i] : pre[i] - pre[low - 1];
      int right = pre[high] - pre[i];

      int score;
      if (left > right) {
        score = right + check(dp, i + 1, high, pre);
      } else if (left < right) {
        score = left + check(dp, low, i, pre);
      } else {
        score = left + Math.max(
            check(dp, low, i, pre),
            check(dp, i + 1, high, pre));
      }
      res = Math.max(score, res);
    }

    return dp[low][high] = res;
  }
}