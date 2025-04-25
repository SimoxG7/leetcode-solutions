import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public long countInterestingSubarrays(List<Integer> nums, int m, int k) {
    Map<Integer, Long> map = new HashMap<>();
    map.put(0, 1L);
    long count = 0;
    int prefix = 0;
    for (int num : nums) {
      if (num % m == k) prefix++;
      int a = prefix % m;
      int target = (a - k + m) % m;
      count += map.getOrDefault(target, 0L);
      map.put(a, map.getOrDefault(a, 0L) + 1);
    }
    return count;
  }
}