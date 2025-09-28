import java.util.Arrays;

class Solution {
  public int largestPerimeter(int[] nums) {
    if (nums.length < 3)
      return 0;

    Arrays.sort(nums);
    int n = nums.length - 1;
    for (int i = n; i >= 2; i--) {
      int a = nums[i];
      int b = nums[i - 1];
      int c = nums[i - 2];

      if (b + c > a) {
        return a + b + c;
      }
    }
    return 0;
  }
}