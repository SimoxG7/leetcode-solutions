import java.util.HashMap;
import java.util.Map;

class Solution {
  public int maximumLength(String s) {
    Map<String, Integer> map = new HashMap<>();
    int n = s.length();

    for (int i = 0; i < n; i++) {
      int j = i;
      do {
        String ss = s.substring(i, j + 1);
        map.put(ss, map.getOrDefault(ss, 0) + 1);
        if (j < n - 1 && s.charAt(j) == s.charAt(j + 1)) {
          j++;
        } else {
          break;
        }
      } while (j < n);
    }

    String maxSubString = "";
    for (String subString : map.keySet()) {
      if (map.get(subString) >= 3 && subString.length() > maxSubString.length()) {
        maxSubString = subString;
      }
    }
    return maxSubString.equals("") ? -1 : maxSubString.length();
  }
}