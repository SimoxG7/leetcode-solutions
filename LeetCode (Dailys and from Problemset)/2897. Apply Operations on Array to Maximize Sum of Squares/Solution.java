import java.util.List;

class Solution {
  private static final int MOD = 1_000_000_007;

  public int maxSum(List<Integer> nums, int k) {
    int[] bitCount = new int[31];

    for (int num : nums) {
      for (int bit = 0; bit < 31; bit++) {
        bitCount[bit] += (num >> bit) & 1;
      }
    }

    long res = 0;

    while (k-- > 0) {
      long value = 0;

      for (int bit = 0; bit < 31; bit++) {
        if (bitCount[bit] > 0) {
          value |= 1L << bit;
          bitCount[bit]--;
        }
      }

      res = (res + value * value) % MOD;
    }

    return (int) res;
  }
}