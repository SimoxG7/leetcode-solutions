import java.util.Arrays;

class Solution {
  public int maximumCount(int[] nums) {
    int n = nums.length;
    if (n == 1) return 1;
    int zeroIndex = Arrays.binarySearch(nums, 0);
    if (zeroIndex < 0) {
      zeroIndex = Math.abs(zeroIndex + 1);
      return Math.max(zeroIndex, n - zeroIndex);
    }
    int postZeroIndex = zeroIndex;
    while (postZeroIndex < n && nums[postZeroIndex] == 0) {
      postZeroIndex++;
    }
    while (zeroIndex >= 0 && nums[zeroIndex] == 0) {
      zeroIndex--;
    }
    return Math.max(zeroIndex + 1, n - postZeroIndex);
  }
}