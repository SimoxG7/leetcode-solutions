class Solution {
  public int numSubarraysWithSum(int[] nums, int goal) {
    return atMost(nums, goal) - atMost(nums, goal - 1);
  }

  private int atMost(int[] nums, int goal) {
    int left, right = 0, sum = 0, result = 0;
    for (left = 0; left < nums.length; left++) {
      sum += nums[left];
      while (sum > goal && right <= left) {
        sum -= nums[right];
        right++;
      }
      result += left - right + 1;
    }
    return result;
  }
}