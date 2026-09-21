class Solution {
  public long[] resultArray(int[] nums, int k) {
    long[] res = new long[k];
    long[] dp = new long[k];

    for (int num : nums) {
      long[] next = new long[k];
      int val = num % k;

      for (int i = 0; i < k; i++) {
        if (dp[i] > 0) {
          next[(i * val) % k] += dp[i];
        }
      }

      next[val]++;

      for (int i = 0; i < k; i++) {
        res[i] += next[i];
      }

      dp = next;
    }

    return res;
  }
}