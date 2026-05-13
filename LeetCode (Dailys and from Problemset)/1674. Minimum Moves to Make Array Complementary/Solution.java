class Solution {
  public int minMoves(int[] nums, int limit) {
    int n = nums.length;
    int[] diff = new int[2 * limit + 2];

    for (int i = 0; i < n / 2; i++) {
      int a = nums[i];
      int b = nums[n - 1 - i];

      int lo = Math.min(a, b);
      int hi = Math.max(a, b);

      // 2 moves for all sums
      diff[2] += 2;
      diff[2 * limit + 1] -= 2;

      // 1 move range
      diff[lo + 1] -= 1;
      diff[hi + limit + 1] += 1;

      // 0 move exact sum
      diff[a + b] -= 1;
      diff[a + b + 1] += 1;
    }

    int res = Integer.MAX_VALUE;
    int curr = 0;

    for (int t = 2; t <= 2 * limit; t++) {
      curr += diff[t];
      res = Math.min(res, curr);
    }

    return res;
  }
}