import java.util.*;

class Solution {
  private String key(int x, int y) {
    return x + "#" + y;
  }

  public int longestBalanced(String s) {
    int n = s.length();
    int a = 0, b = 0, c = 0;
    int ans = 0;

    int run = 0;
    char prev = 0;
    for (int i = 0; i < n; ++i) {
      if (i == 0 || s.charAt(i) != prev)
        run = 1;
      else
        run++;
      prev = s.charAt(i);
      ans = Math.max(ans, run);
    }

    Map<String, Integer> map3 = new HashMap<>();
    Map<String, Integer> mapAbToC = new HashMap<>();
    Map<String, Integer> mapAcToB = new HashMap<>();
    Map<String, Integer> mapBcToA = new HashMap<>();

    map3.put(key(0, 0), 0);
    mapAbToC.put(key(0, 0), 0);
    mapAcToB.put(key(0, 0), 0);
    mapBcToA.put(key(0, 0), 0);

    for (int p = 1; p <= n; ++p) {
      char ch = s.charAt(p - 1);
      if (ch == 'a')
        a++;
      else if (ch == 'b')
        b++;
      else
        c++;

      String k3 = key(b - a, c - a);
      if (map3.containsKey(k3))
        ans = Math.max(ans, p - map3.get(k3));
      else
        map3.put(k3, p);

      String kabc = key(b - a, c);
      if (mapAbToC.containsKey(kabc))
        ans = Math.max(ans, p - mapAbToC.get(kabc));
      else
        mapAbToC.put(kabc, p);

      String kacb = key(c - a, b);
      if (mapAcToB.containsKey(kacb))
        ans = Math.max(ans, p - mapAcToB.get(kacb));
      else
        mapAcToB.put(kacb, p);

      String kbc = key(c - b, a);
      if (mapBcToA.containsKey(kbc))
        ans = Math.max(ans, p - mapBcToA.get(kbc));
      else
        mapBcToA.put(kbc, p);
    }

    return ans;
  }
}