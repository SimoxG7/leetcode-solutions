import java.util.Arrays;

class Solution {
  public int maxTwoEvents(int[][] events) {
    int[] dp = new int[events.length + 1];
    int max = 0;

    Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

    for (int i = events.length - 1; i >= 0; i--) {
      dp[i] = Math.max(dp[i + 1], events[i][2]);
    }

    for (int i = 0; i < events.length; i++) {
      int end = events[i][1];
      int value = events[i][2];

      max = Math.max(max, value);

      int ind = find(events, end + 1);
      if (ind != -1)
        max = Math.max(max, value + dp[ind]);
    }

    return max;
  }

  public int find(int[][] events, int start) {
    int lo = 0;
    int hi = events.length - 1;

    int lowest = -1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int currStart = events[mid][0];

      if (currStart >= start) {
        lowest = mid;
        hi = mid - 1;
      }

      else {
        lo = mid + 1;
      }
    }

    return lowest;
  }
}