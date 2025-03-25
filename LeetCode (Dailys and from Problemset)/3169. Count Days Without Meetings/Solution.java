import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public int countDays(int days, int[][] meetings) {
    Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
    int daysWithMeetings = 0;
    List<int[]> mergedInterals = new ArrayList<>();
    mergedInterals.add(meetings[0]);

    for (int i = 1; i < meetings.length; i++) {
      int[] lastMergedInterval = mergedInterals.get(mergedInterals.size() - 1);
      if (meetings[i][0] <= lastMergedInterval[1]) {
        lastMergedInterval[1] = Math.max(lastMergedInterval[1], meetings[i][1]);
      } else {
        mergedInterals.add(meetings[i]);
      }
    }
    for (int i = 0; i < mergedInterals.size(); i++) {
      daysWithMeetings += mergedInterals.get(i)[1] - mergedInterals.get(i)[0] + 1;
    }
    return days - daysWithMeetings;
  }
}