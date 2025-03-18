class Solution {
  public int longestNiceSubarray(int[] nums) {
    int n = nums.length, left = 0, right = 0, max = 0, mask = 0;
    while (right < n) {
      while ((mask & nums[right]) != 0)
        mask -= nums[left++];
      mask += nums[right];
      max = Math.max(max, right - left + 1);
      right++;
    }
    return max;
  }
}