class Solution {
  public int maximumCandies(int[] candies, long k) {
    int max = candies[0];
    for (int i = 1; i < candies.length; i++) {
      max = Math.max(candies[i], max);
    }
    int low = 1, high = max;
    int res = 0;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (canDistribute(mid, candies, k)) {
        res = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return res;
  }

  private boolean canDistribute(int mid, int candies[], long k) {
    long c = 0;
    for (int i = 0; i < candies.length; i++) {
      if (candies[i] >= mid) {
        c += candies[i] / mid;
      }
    }
    return c >= k;
  }
}