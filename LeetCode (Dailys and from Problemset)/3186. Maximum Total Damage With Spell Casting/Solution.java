import java.util.Arrays;

class Solution {
  public long maximumTotalDamage(int[] power) {
    Arrays.sort(power);
    return calc(new long[power.length], power, 0);
  }

  private long calc(long[] dp, int[] power, int i) {
    if (i >= dp.length)
      return 0;
    if (dp[i] != 0)
      return dp[i];

    long take = power[i], nottake = 0;
    int j = i + 1, k = -1;
    for (; j < dp.length; j++) {
      // Take all same powers
      if (power[j] == power[i]) {
        take += power[j];
        // Found next qualifying power after taking power[i]
      } else if (power[j] > power[i] + 2) {
        break;
      }

      // Skip current power, then first index
      // to be evaluated is nearest different one.
      if (k == -1 && power[j] > power[i]) {
        k = j;
      }
    }

    if (j < dp.length)
      take += calc(dp, power, j);

    if (k != -1)
      nottake = calc(dp, power, k);

    return dp[i] = Math.max(take, nottake);
  }
}