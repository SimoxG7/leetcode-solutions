import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
  public int longestPalindrome(String[] words) {
    Map<String, Integer> map = new HashMap<>();
    for (String w : words) {
      map.put(w, map.getOrDefault(w, 0) + 1);
    }
    int len = 0;
    List<String> set = new ArrayList<>();
    set.addAll(map.keySet());
    boolean middle = false;
    for (int i = 0; i < set.size(); i++) { 
      String w = set.get(i);
      String rev = "" + w.charAt(1) + w.charAt(0);
      if (map.containsKey(rev)) {
        if (w.charAt(0) == w.charAt(1)) {
          if (map.get(w) % 2 == 1) {
            if (!middle) {
              len += map.get(w);
              middle = true;
            }
            else len += map.get(w) - 1;
          } else {
            len += map.get(w);
          } 
        } else {
          len += 2*Math.min(map.get(w), map.get(rev));
        }
        map.remove(rev);
      }
      map.remove(w);
    }
    return len*2;
  }
}