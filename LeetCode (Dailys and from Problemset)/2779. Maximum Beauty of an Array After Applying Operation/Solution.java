import java.util.Arrays;

class Solution {
  public int maximumBeauty(int[] nums, int k) {
    Arrays.sort(nums);
    int res = 0;
    int left = 0;

    for (int right = 0; right < nums.length; right++) {
      int diff = nums[right] - nums[left];
      while (diff > 2 * k) {
        left++;
        diff = nums[right] - nums[left];
      }
      res = Math.max(res, right - left + 1);
    }
    return res;
  }
}