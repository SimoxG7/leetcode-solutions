import java.util.HashMap;
import java.util.Map;

class Solution {
  public long countBadPairs(int[] nums) {
    long count = 0;
    long n = nums.length;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      int k = nums[i] - i;
      if (map.containsKey(k)) {
        count = count + map.get(k);
        map.put(k, map.get(k) + 1);
      } else {
        map.put(k, 1);
      }
    }
    return n * (n - 1) / 2 - count;
  }
}