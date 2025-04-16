import java.util.HashMap;
import java.util.Map;

class Solution {
  public long countGood(int[] nums, int k) {
    if (nums.length == 1) {
      return 0;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int start = 0, end = 0;
    long count = 0;
    int pairs = 0;
    int len = nums.length;

    while (start <= end && end < len) {
      int freq = map.getOrDefault(nums[end], 0);
      map.put(nums[end], freq + 1);
      pairs += freq;

      while (pairs >= k) {
        count += len - end;
        freq = map.get(nums[start]);
        pairs -= freq - 1;
        map.put(nums[start], map.get(nums[start]) - 1);
        start++;
      }
      end++;
    }
    return count;
  }
}