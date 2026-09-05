class Solution {
  public int firstStableIndex(int[] nums, int k) {
    int n = nums.length;

    int[] minAtIndex = new int[n];
    int min = Integer.MAX_VALUE;
    for (int i = n - 1; i >= 0; i--) {
      min = Math.min(min, nums[i]);
      minAtIndex[i] = min;
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, nums[i]);
      int diff = max - minAtIndex[i];
      if (diff <= k)
        return i;
    }

    return -1;
  }
}