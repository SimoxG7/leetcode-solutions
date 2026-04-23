
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public long[] distance(int[] nums) {
    Map<Integer, List<Integer>> numToIndexes = new HashMap<>();
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      numToIndexes.computeIfAbsent(nums[i], l -> new ArrayList<>()).add(i);
    }

    long[] res = new long[n];
    for (List<Integer> indexes : numToIndexes.values()) {
      long total = 0;
      for (int idx : indexes) {
        total += idx;
      }

      long prefixTotal = 0;
      int indexesSize = indexes.size();

      for (int i = 0; i < indexesSize; i++) {
        int idx = indexes.get(i);
        res[idx] = total - prefixTotal * 2 + (long) idx * (2 * i - indexesSize);
        prefixTotal += idx;
      }
    }
    return res;
  }
}