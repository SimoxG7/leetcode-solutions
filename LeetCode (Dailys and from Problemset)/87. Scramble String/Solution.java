import java.util.HashMap;
import java.util.Map;

class Solution {

  Map<String, Boolean> map = new HashMap<>();

  public boolean isScramble(String s1, String s2) {
    int n = s1.length();

    if (s1.equals(s2))
      return true;

    if (n == 1)
      return false;

    String key = s1 + "*" + s2;

    if (map.containsKey(key))
      return map.get(key);

    for (int i = 1; i < n; i++) {

      boolean withoutswap = isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i));

      if (withoutswap) {
        map.put(key, true);
        return true;
      }

      boolean withswap = isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i));

      if (withswap) {
        map.put(key, true);
        return true;
      }
    }
    map.put(key, false);
    return false;
  }
}