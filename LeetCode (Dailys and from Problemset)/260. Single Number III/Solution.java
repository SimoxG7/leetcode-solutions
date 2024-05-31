import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
  public int[] singleNumber(int[] nums) {
    Map<Integer, Boolean> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], !map.getOrDefault(nums[i], true));
    }
    int[] res = new int[2];
    int index = 0;
    for (Entry<Integer, Boolean> entry : map.entrySet()) {
      if (!entry.getValue()) res[index++] = entry.getKey();
    }
    return res;
  }
}