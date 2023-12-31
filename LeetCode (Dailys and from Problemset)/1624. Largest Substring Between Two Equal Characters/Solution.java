import java.util.HashMap;
import java.util.Map;

class Solution {
  public int maxLengthBetweenEqualCharacters(String s) {
    Map<Character, Integer> lastOccurrence = new HashMap<>();
    int maxLength = -1;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (lastOccurrence.containsKey(c)) {
        maxLength = Math.max(maxLength, i - lastOccurrence.get(c) - 1);
      } else {
        lastOccurrence.put(c, i);
      }
    }

    return maxLength;
  }
}