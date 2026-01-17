import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  static final int MOD = 1000000007;

  public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
    Set<Integer> hGaps = collectGaps(hFences, m);
    Set<Integer> vGaps = collectGaps(vFences, n);

    long best = 0;
    for (int g : hGaps) {
      if (vGaps.contains(g)) {
        best = Math.max(best, g);
      }
    }

    if (best == 0)
      return -1;
    return (int) ((best * best) % MOD);
  }

  private Set<Integer> collectGaps(int[] fences, int limit) {
    List<Integer> points = new ArrayList<>();
    points.add(1);
    points.add(limit);

    for (int f : fences)
      points.add(f);
    Collections.sort(points);

    Set<Integer> gaps = new HashSet<>();
    for (int i = 0; i < points.size(); i++) {
      for (int j = i + 1; j < points.size(); j++) {
        gaps.add(points.get(j) - points.get(i));
      }
    }
    return gaps;
  }
}