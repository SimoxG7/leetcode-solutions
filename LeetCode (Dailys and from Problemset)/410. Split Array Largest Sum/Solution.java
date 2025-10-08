class Solution {
  public int splitArray(int[] nums, int k) {
    int low = 0;
    int high = Integer.MAX_VALUE;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (helper(mid, nums, k)) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  private boolean helper(int posAns, int[] nums, int k) {
    int count = 1;
    int sum = 0;
    for (int val : nums) {
      sum += val;
      if (sum > posAns) {
        count++;
        sum = val;
        if (sum > posAns)
          return false;
      }
    }
    return count <= k;
  }
}