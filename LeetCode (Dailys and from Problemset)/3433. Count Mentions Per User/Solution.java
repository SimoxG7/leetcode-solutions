import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
  public int[] countMentions(int numberOfUsers, List<List<String>> events) {
    int[] mentions = new int[numberOfUsers];
    int[] isOfflineUntilTimestamp = new int[numberOfUsers];
    Collections.sort(events, new Comparator<List<String>>() {
      @Override
      public int compare(List<String> o1, List<String> o2) {
        int timestampDiff = Integer.parseInt(o1.get(1)) - Integer.parseInt(o2.get(1));
        if (timestampDiff != 0) return timestampDiff;
        int o1MessagePriority = o1.get(0).equals("OFFLINE") ? 0 : 1;
        int o2MessagePriority = o2.get(0).equals("OFFLINE") ? 0 : 1;
        return o1MessagePriority - o2MessagePriority;
      }
    });
    for (List<String> event : events) {
      String messageType = event.get(0);
      int timestamp = Integer.parseInt(event.get(1));
      if (messageType.equals("OFFLINE")) {
        int userId = Integer.parseInt(event.get(2));
        isOfflineUntilTimestamp[userId] = timestamp + 59;
      } else {
        String mentionsString = event.get(2);
        if (mentionsString.equals("ALL")) {
          for (int i = 0; i < numberOfUsers; i++) mentions[i]++;
        } else if (mentionsString.equals("HERE")) {
          for (int i = 0; i < numberOfUsers; i++) {
            if (isOfflineUntilTimestamp[i] < timestamp) mentions[i]++;
          }
        } else {
          String[] idSplits = mentionsString.replace("id", "").trim().split("\\s+");
          for (String idString : idSplits) {
            int id = Integer.parseInt(idString);
            mentions[id]++;
          }
        }
      }
    }
    return mentions;
  }
}