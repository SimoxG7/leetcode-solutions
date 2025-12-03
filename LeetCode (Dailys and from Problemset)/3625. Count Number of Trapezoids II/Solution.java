import java.util.HashMap;
import java.util.Map;

class Solution {
  public int countTrapezoids(int[][] points) {
    int n = points.length;

    Map<Integer, Map<Integer, Integer>> segments = new HashMap<>();
    Map<Integer, Map<Integer, Integer>> parallelSegments = new HashMap<>();

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int dx = points[j][0] - points[i][0];
        int dy = points[j][1] - points[i][1];

        if (dx < 0 || (dx == 0 && dy < 0)) {
          dx = -dx;
          dy = -dy;
        }

        int g = gcd(dx, Math.abs(dy));
        int sx = dx / g;
        int sy = dy / g;

        int lineParam = sx * points[i][1] - sy * points[i][0];

        int keyNormalized = (sx << 12) | (sy + 2000);
        int keyFull = (dx << 12) | (dy + 2000);

        segments.computeIfAbsent(keyNormalized, k -> new HashMap<>())
            .merge(lineParam, 1, Integer::sum);
        parallelSegments.computeIfAbsent(keyFull, k -> new HashMap<>())
            .merge(lineParam, 1, Integer::sum);
      }
    }

    return calculate(segments) - calculate(parallelSegments) / 2;
  }

  private int calculate(Map<Integer, Map<Integer, Integer>> map) {
    long result = 0;

    for (Map<Integer, Integer> innerMap : map.values()) {
      long total = 0;

      for (int count : innerMap.values()) {
        total += count;
      }

      for (int count : innerMap.values()) {
        total -= count;
        result += (long) count * total;
      }
    }

    return (int) result;
  }

  private int gcd(int a, int b) {
    while (b != 0) {
      int temp = a % b;
      a = b;
      b = temp;
    }
    return Math.abs(a);
  }
}