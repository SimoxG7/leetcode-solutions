import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public int numberOfArithmeticSlices(int[] nums) {
    Map<Integer, List<Integer>> nums2mp = new HashMap<>();
    int len = nums.length;
    int[][] dp = new int[len][len];
    int res = 0;
    for (int i = 0; i < len; i++) {
      nums2mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
    }

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < i; j++) {
        long prev = 2L * nums[j] - nums[i];
        if (prev > Integer.MAX_VALUE || prev < Integer.MIN_VALUE) {
          continue;
        }
        List<Integer> indices = nums2mp.getOrDefault((int) prev, null);
        if (indices != null) {
          for (int k : indices) {
            if (k >= j)
              break;
            dp[i][j] += dp[j][k] + 1;
          }
        }
        res += dp[i][j];
      }
    }
    return res;
  }
}
