import java.util.Arrays;

class Solution {
  public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(intervals, (int[] a, int[] b) -> {
      int diff = Integer.compare(a[0], b[0]);
      if (diff == 0) return Integer.compare(b[1], a[1]);
      return diff;
    });

    int count = 0;
    int maxEnd = 0;

    for (int[] interval : intervals) {
      int currentEnd = interval[1];

      if (currentEnd > maxEnd) {
        count++;
        maxEnd = currentEnd;
      }
    }

    return count;
  }
}