import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int countCompleteSubarrays(int[] nums) {
    int k = (int) Arrays.stream(nums).distinct().count();
    int res = 0;
    int left = 0;
    Map<Integer, Integer> windowCounts = new HashMap<>();
    int n = nums.length;
    for (int right = 0; right < n; right++) {
      int rightNum = nums[right];
      windowCounts.put(rightNum, windowCounts.getOrDefault(rightNum, 0) + 1);
      while (windowCounts.size() == k) {
        res += n - right;
        int leftNum = nums[left];
        int count = windowCounts.get(leftNum);
        windowCounts.put(leftNum, count - 1);
        if (count - 1 == 0) {
          windowCounts.remove(leftNum);
        }
        left++;
      }
    }
    return res;
  }
}