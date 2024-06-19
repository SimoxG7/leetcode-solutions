import java.util.Arrays;

class Solution {
  private boolean isSafe(int mid, int[] bloomDay, int m, int k) {
    int consecCount = 0, numOfBouquet = 0;
    for (int i = 0; i < bloomDay.length; i++) {
      if (bloomDay[i] <= mid) {
        consecCount++;
      } else {
        consecCount = 0;
      }

      if (consecCount == k) {
        numOfBouquet++;
        consecCount = 0;
      }
    }
    return (numOfBouquet >= m);
  }

  public int minDays(int[] bloomDay, int m, int k) {
    int n = bloomDay.length;
    if ((long) m * k > n)
      return -1;

    int left = 1;
    int right = Arrays.stream(bloomDay).max().getAsInt();
    int res = -1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (isSafe(mid, bloomDay, m, k)) {
        res = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return res;
  }
}