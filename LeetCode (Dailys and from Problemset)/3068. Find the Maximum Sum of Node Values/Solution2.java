class Solution {
  public long maximumValueSum(int[] nums, int k, int[][] edges) {
    long res = 0;
    int diff = 1 << 30, c = 0;
    for (int num : nums) {
      int b = num ^ k;
      res += Math.max(num, b);
      c ^= num < b ? 1 : 0;
      diff = Math.min(diff, Math.abs(num - b));
    }
    return res - diff * c;
  }
}