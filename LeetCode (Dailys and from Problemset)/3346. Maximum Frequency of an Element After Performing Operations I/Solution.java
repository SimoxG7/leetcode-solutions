import java.util.HashMap;
import java.util.Map;

class Solution {
  public int maxFrequency(int[] nums, int k, int numOperations) {
    int ans = 0, max = nums[0];
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      max = Math.max(max, num);
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int[] count = new int[max + 1];
    for (int num : nums) {
      if (num - k < 0) count[0]++;
      else count[num - k]++;
      if (num + k + 1 <= max) count[num + k + 1]--;
    }
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
      int freq = map.getOrDefault(i, 0);
      int extra = count[i] - freq;
      int cur = freq + Math.min(extra, numOperations);
      ans = Math.max(ans, cur);
    }
    return ans;
  }
}