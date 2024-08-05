import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
  public String kthDistinct(String[] arr, int k) {
    Map<String, Integer> strings = new LinkedHashMap<>();
    for (String s : arr) {
      strings.put(s, strings.getOrDefault(s, 0) + 1);
    }
    int found = 1;
    for (Entry<String, Integer> entry : strings.entrySet()) {
      if (entry.getValue() == 1) {
        if (found++ == k) {
          return entry.getKey();
        }
      }
    }
    return "";
  }
}