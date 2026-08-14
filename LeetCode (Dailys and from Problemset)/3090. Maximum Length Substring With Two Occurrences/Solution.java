import java.util.HashMap;
import java.util.Map;

class Solution {
  public int maximumLengthSubstring(String s) {
    Map<Character, Integer> count = new HashMap<>();
    int left = 0, res = 0;
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      count.put(c, count.getOrDefault(c, 0) + 1);
      while (count.get(c) > 2) {
        char leftChar = s.charAt(left);
        count.put(leftChar, count.get(leftChar) - 1);
        left++;
      }
      res = Math.max(res, right - left + 1);
    }
    return res;
  }
}