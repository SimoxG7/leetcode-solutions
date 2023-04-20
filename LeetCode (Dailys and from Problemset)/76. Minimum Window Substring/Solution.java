import java.util.HashMap;
import java.util.Map;

class Solution {

  public String minWindow(String s, String t) {
    int start = 0;
    int end = 0;
    int startIndex = -1;
    int minLength = Integer.MAX_VALUE;
    Map<Character, Integer> map = makeMap(t);
    int counter = t.length();
    int n = s.length();
    while (start < n && end < n) {
      Integer countAtChar = map.get(s.charAt(end));
      if (countAtChar == null) {
        countAtChar = 0;
      }
      if (countAtChar > 0)
        counter--;
      map.put(s.charAt(end), countAtChar - 1);
      end++;
      while (counter == 0) {
        int curLength = end - start;
        if (curLength < minLength) {
          startIndex = start;
          minLength = curLength;
        }
        countAtChar = map.get(s.charAt(start));
        map.put(s.charAt(start), countAtChar + 1);
        // update the counter only for charaters in "t"
        if (map.get(s.charAt(start)) > 0)
          counter++;
        start++;
      }
    }
    if (startIndex == -1)
      return "";
    return s.substring(startIndex, startIndex + minLength);
  }

  public Map<Character, Integer> makeMap(String t) {
    Map<Character, Integer> sourceMap = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      Character c = t.charAt(i);
      Integer count = sourceMap.get(c);
      if (count == null) {
        sourceMap.put(c, 1);
      } else {
        sourceMap.put(c, count + 1);
      }
    }
    return sourceMap;
  }

}
