import java.util.HashSet;
import java.util.Set;

class Solution {
  public int longestSquareStreak(int[] nums) {
    Set<Long> set = new HashSet<>();
    int max = -1;

    for (int num : nums) {
      set.add((long) num);
    }

    for (int num : nums) {
      long current = num;
      int cnt = 1;
      while (set.contains(current * current)) {
        current = current * current;
        cnt++;
      }
      if (cnt >= 2)
        max = Math.max(cnt, max);
    }
    return max;
  }
}