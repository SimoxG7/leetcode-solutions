import java.util.HashMap;
import java.util.Map;

class Solution {
  public int specialTriplets(int[] nums) {
    final int MOD = 1_000_000_007;
    Map<Integer, Long> left = new HashMap<>();
    Map<Integer, Long> right = new HashMap<>();
    for (int num : nums)
      right.put(num, right.getOrDefault(num, 0L) + 1);
    long ans = 0;
    for (int num : nums) {
      right.put(num, right.get(num) - 1);
      int need = num * 2;
      long lc = left.getOrDefault(need, 0L);
      long rc = right.getOrDefault(need, 0L);
      ans = (ans + lc * rc) % MOD;
      left.put(num, left.getOrDefault(num, 0L) + 1);
    }
    return (int) ans;
  }
}