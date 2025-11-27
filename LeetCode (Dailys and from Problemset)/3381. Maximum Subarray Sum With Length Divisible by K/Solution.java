class Solution {
  public long maxSubarraySum(int[] nums, int k) {
    long result = Long.MIN_VALUE, sum = 0;
    long[] map = new long[k];
    for (int i = 0; i < k - 1; i++) {
      sum += nums[i];
      map[i] = sum;
    }
    for (int i = k - 1, p = k - 1; i < nums.length; i++, p++) {
      if (p >= k) {
        p -= k;
      }
      sum += nums[i];
      result = Math.max(result, sum - map[p]);
      map[p] = Math.min(map[p], sum);
    }
    return result;
  }
}