class Solution {
  public int maxCoins(int[] nums) {

    int n = nums.length;
    int arr[] = new int[n + 2];
    for (int i = 0; i < n; i++) {
      arr[i + 1] = nums[i];
    }
    arr[0] = 1;
    arr[n + 1] = 1;
    int dp[][] = new int[n + 2][n + 2];
    // dp[i][j] - storing the max coins u can earn in this interval/subarray

    for (int wlen = 1; wlen <= n; wlen++) {
      for (int left = 1; left <= n - wlen + 1; left++) {
        int right = left + wlen - 1;

        // now iterate this window, and give chance to every ballon to burst at last
        for (int k = left; k <= right; k++) {
          dp[left][right] = Math.max(dp[left][right],
              dp[left][k - 1] + // left subarray
                  dp[k + 1][right] + // right subarray
                  (arr[k] * arr[left - 1] * arr[right + 1]) // bursting k index ballon at last , and intervals side
                                                            // balloons will bust with last balloon
          );
        }
      }
    }

    return dp[1][n]; // returning answer stored for orginal size problem

  }
}