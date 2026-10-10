
class Solution {
  public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
    int n = nums1.length;
    long k = (long) k1 + k2;

    int[] dif = new int[n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      dif[i] = Math.abs(nums1[i] - nums2[i]);
      max = Math.max(max, dif[i]);
    }
    int left = 0, right = max;
    while (left < right) {
      int mid = (left + right) / 2;
      long need = 0;
      for (int i = 0; i < n; i++) {
        need += Math.max(0, dif[i] - mid);
      }
      if (need <= k) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    long res = 0;
    long used = 0;
    for (int i = 0; i < n; i++) {
      int x = Math.min(dif[i], left);
      res += (long) x * x;
      used += dif[i] - x;
    }
    k -= used;
    for (int i = 0; i < n && k > 0; i++) {
      if (dif[i] >= left && left > 0) {
        res -= 2L * left - 1;
        k--;
      }
    }
    return res;
  }
}
