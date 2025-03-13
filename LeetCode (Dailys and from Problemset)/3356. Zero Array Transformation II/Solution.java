class Solution {
  public int minZeroArray(int[] nums, int[][] queries) {
    int n = nums.length;
    int q = queries.length;
    int curr = 0;
    while (curr < n && nums[curr] == 0)
      curr++;
    if (curr == n)
      return 0;
    int[] diff = new int[n + 1];
    diff[0] = nums[0];
    for (int i = 1; i < n; ++i) {
      diff[i] = nums[i] - nums[i - 1];
    }
    int left, right, val;
    for (int i = 0; i < q; ++i) {
      left = queries[i][0];
      right = queries[i][1];
      val = queries[i][2];
      if (left > curr) {
        diff[left] -= val;
        diff[right + 1] += val;
      } else if (right >= curr) {
        diff[curr] -= val;
        diff[right + 1] += val;
      }
      if (diff[curr] <= 0) {
        while (curr < n && diff[curr] <= 0) {
          if (++curr < n) {
            diff[curr] += diff[curr - 1];
          }
        }
        if (curr == n)
          return i + 1;
      }
    }
    return -1;
  }
}

// class Solution {
// public int minZeroArray(int[] nums, int[][] queries) {
// int n = nums.length, q = queries.length;
// boolean[] isZero = new boolean[n];
// int nonZeroCount = 0;
// for (int i = 0; i < n; i++) {
// if (nums[i] == 0) isZero[i] = true;
// else nonZeroCount++;
// }
// for (int i = 0; i < queries.length; i++) {
// if (nonZeroCount == 0) return i;
// int left = queries[i][0], right = queries[i][1], val = queries[i][2];
// for (int j = left; j <= right; j++) {
// if (isZero[j]) continue;
// nums[j] = Math.max(0, nums[j] - val);
// if (nums[j] == 0) {
// nonZeroCount--;
// isZero[j] = true;
// }
// }
// }
// return nonZeroCount == 0 ? q : -1;
// }
// }