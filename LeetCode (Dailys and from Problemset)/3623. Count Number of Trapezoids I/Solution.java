import java.util.HashMap;
import java.util.Map;

class Solution {
  public int countTrapezoids(int[][] points) {
    int MOD = 1_000_000_007;
    Map<Integer, Long> map = new HashMap<>();
    for (int[] point : points) {
      map.put(point[1], map.getOrDefault(point[1], 0L) + 1);
    }
    long prev = 0;
    long curr = 0;
    long res = 0;
    for (long val : map.values()) {
      curr = (val * (val - 1) / 2) % MOD;
      res = (res + prev * curr) % MOD;
      prev = (prev + curr) % MOD;
    }
    return (int) res;
  }
}