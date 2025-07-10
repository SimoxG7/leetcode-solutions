class Solution {
  public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
    int n = startTime.length;
    int[] gaps = new int[n + 1];

    gaps[0] = startTime[0];
    for (int i = 1; i < n; i++) {
      gaps[i] = startTime[i] - endTime[i - 1];
    }
    gaps[n] = eventTime - endTime[n - 1];

    int totalGaps = 0;
    for (int i = 0; i <= k; i++) {
      totalGaps += gaps[i];
    }

    int maxTime = totalGaps;
    for (int i = k + 1; i < gaps.length; i++) {
      totalGaps = totalGaps + gaps[i] - gaps[i - k - 1];
      maxTime = Math.max(totalGaps, maxTime);
    }
    return maxTime;
  }
}