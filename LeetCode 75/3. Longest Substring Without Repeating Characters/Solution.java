import java.util.HashMap;
import java.util.Map;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> found = new HashMap<>();
    int max = 0;
    int len = 0;
    for (int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);
      if (found.containsKey(curr)) {
        max = Math.max(max, len);
        i = found.get(curr);
        found = new HashMap<>();
        len = 0;
      } else {
        found.put(curr, i);
        len++;
      }
    }
    return Math.max(len, max);
  }
}