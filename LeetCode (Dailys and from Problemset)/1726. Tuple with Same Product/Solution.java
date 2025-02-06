import java.util.HashMap;
import java.util.Map;

class Solution {
  public int tupleSameProduct(int[] nums) {
    int n = nums.length;
    int result = 0;
    Map<Integer, Integer> countMap = new HashMap<>();

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int product = nums[i] * nums[j];
        countMap.put(product, countMap.getOrDefault(product, 0) + 1);
      }
    }

    for (int count : countMap.values()) {
      if (count > 1) {
        result += (count * (count - 1) / 2) * 8;
      }
    }
    return result;
  }

}