import java.util.HashMap;
import java.util.Map;

class Solution {
  public int longestSubsequence(int[] arr, int difference) {
    int n = arr.length;
    Map<Integer, Integer> dp = new HashMap<>();
    int res = 1;
    for (int i = 0; i < n; i++) {
      int num = arr[i];
      if (dp.containsKey(num - difference)) {
        dp.put(num, dp.get(num - difference) + 1);
      } else {
        dp.put(num, 1);
      }
      res = Math.max(res, dp.get(num));
    }
    return res;
  }
}