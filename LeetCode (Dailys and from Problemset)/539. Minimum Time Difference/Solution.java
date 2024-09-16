import java.util.Arrays;
import java.util.List;

class Solution {

  public int findMinDifference(List<String> timePoints) {

    int[] times = new int[timePoints.size()];
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < timePoints.size(); i++) {

      String[] timeArr = timePoints.get(i).split(":");
      times[i] = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
    Arrays.sort(times);

    for (int i = 1; i < times.length; i++) {
      min = Math.min(times[i] - times[i - 1], min);
    }

    int wrapAroundTime = Math.abs(times[times.length - 1] - (times[0] + 1440));
    min = Math.min(wrapAroundTime, min);

    return min;
  }

}