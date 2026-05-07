class Solution {
  public int[] maxValue(int[] nums) {
    int n = nums.length;

    int[] suffixMin = new int[n + 1];
    suffixMin[n] = Integer.MAX_VALUE;
    for (int i = n - 1; i >= 0; i--) {
      suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
    }

    int[] res = new int[n];
    int left = 0;

    while (left < n) {
      int right = left;
      int componentMax = nums[left];

      while (right + 1 < n && componentMax > suffixMin[right + 1]) {
        right++;
        componentMax = Math.max(componentMax, nums[right]);
      }

      for (int i = left; i <= right; i++) {
        res[i] = componentMax;
      }

      left = right + 1;
    }

    return res;
  }
}