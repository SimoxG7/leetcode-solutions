import java.util.Arrays;

class Solution {
  public long countFairPairs(int[] nums, int lower, int upper) {
    Arrays.sort(nums);
    return smaller(nums, upper) - smaller(nums, lower - 1);
  }

  private long smaller(int[] nums, int value) {
    int left = 0;
    int right = nums.length - 1;
    long result = 0;
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum <= value) {
        result += (right - left);
        left++;
      } else {
        right--;
      }
    }
    return result;
  }
}