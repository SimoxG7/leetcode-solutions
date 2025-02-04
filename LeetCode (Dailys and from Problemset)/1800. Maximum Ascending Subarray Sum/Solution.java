class Solution {
  public int maxAscendingSum(int[] nums) {
    int max = nums[0];
    int currSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] <= nums[i - 1]) {
        max = Math.max(currSum, max);
        currSum = nums[i];
      } else {
        currSum += nums[i];
      }
    }
    return Math.max(currSum, max);
  }
}