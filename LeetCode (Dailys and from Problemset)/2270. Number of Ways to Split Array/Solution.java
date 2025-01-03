class Solution {
  public int waysToSplitArray(int[] nums) {
    long sum = 0;
    for (int num : nums) {
      sum += num;
    }

    long prefixSum = 0;
    int ans = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      prefixSum += nums[i];
      if (prefixSum >= (sum - prefixSum)) {
        ans++;
      }
    }

    return ans;
  }
}