import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int[] findRightInterval(int[][] intervals) {
    int n = intervals.length;

    Map<Integer, Integer> startToIndexMap = new HashMap<>(n);
    for (int i = 0; i < n; i++) {
      int[] interval = intervals[i];
      startToIndexMap.put(interval[0], i);
    }

    Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

    int[] res = new int[n];

    for (int[] interval : intervals) {
      int resultIndex = startToIndexMap.get(interval[0]);
      res[resultIndex] = startToIndexMap.getOrDefault(binarySearch(intervals, interval[1]), -1);
    }

    return res;

  }

  private Integer binarySearch(int[][] intervals, int intervalEnd) {
    int left = 0, right = intervals.length - 1;

    if (intervalEnd > intervals[right][0]) return null;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int midIntervalStart = intervals[mid][0];

      if (midIntervalStart == intervalEnd) return midIntervalStart;
      else if (midIntervalStart < intervalEnd) left = mid + 1;
      else right = mid - 1;
    }

    return intervals[left][0];
  }
}