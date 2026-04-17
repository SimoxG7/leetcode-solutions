import java.util.HashMap;
import java.util.Map;

class Solution {
  public int minMirrorPairDistance(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int val = nums[i];
      int reversed = reverse(val);
      if (map.containsKey(val)) {
        res = Math.min(res, i - map.get(val));
      }
      map.put(reversed, i);
      if (res == 1) return res;
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  private int reverse(int val) {
    int res = 0;
    while (val > 0) {
      res = res * 10 + val % 10;
      val = val / 10;
    }
    return res;
  }
}