class Solution {
  public long repairCars(int[] ranks, int cars) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < ranks.length; i++) {
      max = Math.max(max, ranks[i]);
    }
    long low = 1, high = (long) max * cars * cars;
    long ans = 0;
    while (low <= high) {
      long mid = (low + high) / 2;
      if (valid(mid, ranks, cars)) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }

  private boolean valid(long mid, int ranks[], int cars) {
    long count = 0;
    for (int i : ranks) {
      long c = mid / i;
      count += (long) Math.sqrt(c);
    }
    if (count >= cars)
      return true;
    return false;

  }
}