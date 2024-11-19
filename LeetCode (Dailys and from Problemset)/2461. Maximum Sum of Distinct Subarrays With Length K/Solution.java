class Solution {
  public long maximumSubarraySum(int[] nums, int k) {
    int[] freq = new int[100_001];
    long sum = 0, maxSum = 0;
    int uniqueCount = 0;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
      freq[nums[i]]++;
      if (freq[nums[i]] == 1)
        uniqueCount++;
    }
    if (uniqueCount == k)
      maxSum = sum;
    for (int i = k; i < nums.length; i++) {
      sum += nums[i];
      freq[nums[i]]++;
      if (freq[nums[i]] == 1)
        uniqueCount++;
      int left = nums[i - k];
      sum -= left;
      freq[left]--;
      if (freq[left] == 0)
        uniqueCount--;
      if (uniqueCount == k)
        maxSum = Math.max(maxSum, sum);
    }
    return maxSum;
  }
}
