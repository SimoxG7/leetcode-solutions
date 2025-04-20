import java.util.Map;
import java.util.HashMap;

class Solution {
  public int numRabbits(int[] answers) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int ans : answers) {
      freq.put(ans, freq.getOrDefault(ans, 0) + 1);
    }
    int res = 0;
    for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
      int ans = entry.getKey(), count = entry.getValue();
      if (ans == 0)
        res += count;
      else
        res += (int) Math.ceil((double) count / (ans + 1)) * (ans + 1);
    }
    return res;
  }
}
