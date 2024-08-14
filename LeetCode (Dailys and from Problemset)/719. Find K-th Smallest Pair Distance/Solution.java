import java.util.Arrays;

class Solution {
  public int smallestDistancePair(int[] nums, int k) {
    int result = 0;
    int n = nums.length;
    Arrays.sort(nums);
    int right = Math.abs(nums[0] - nums[n - 1]);
    int left = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int countPairsWhoseDiffLessThanEqualMid = countPairs(nums, mid);
      if (countPairsWhoseDiffLessThanEqualMid < k) {
        left = mid + 1;
      } else {
        result = mid;
        right = mid - 1;
      }
    }
    return result;

  }

  private int countPairs(int[] nums, int diff) {
    int head = 0;
    int tail = 1;
    int n = nums.length;
    int pairCount = 0;
    while (tail < n) {
      while (nums[tail] - nums[head] > diff)
        head++;
      pairCount += (tail - head);
      tail++;
    }
    return pairCount;
  }
}