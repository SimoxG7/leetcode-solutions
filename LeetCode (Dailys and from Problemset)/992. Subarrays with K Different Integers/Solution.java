import java.util.HashMap;
import java.util.Map;

class Solution {
  protected int solve(int[] nums, int k) {
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int j = 0, i = 0;
    while (j < nums.length) {
      map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
      while (map.size() > k) {
        map.put(nums[i], map.get(nums[i]) - 1);
        if (map.get(nums[i]) == 0)
          map.remove(nums[i]);
        i++;
      }
      res += j - i + 1;
      j++;
    }
    return res;
  }

  public int subarraysWithKDistinct(int[] nums, int k) {
    return solve(nums, k) - solve(nums, k - 1);
  }
}
