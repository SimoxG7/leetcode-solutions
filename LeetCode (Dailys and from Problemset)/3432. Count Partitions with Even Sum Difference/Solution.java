class Solution {
  public int countPartitions(int[] nums) {
    int sum = 0, n = nums.length;
    for (int i = 0; i < n; i++) sum += nums[i];
    int left = 0, count = 0;
    for (int i = 0; i < n - 1; i++) {
      left += nums[i];
      sum -= nums[i];
      if (left % 2 == sum % 2) count++;
    }
    return count;
  }
}