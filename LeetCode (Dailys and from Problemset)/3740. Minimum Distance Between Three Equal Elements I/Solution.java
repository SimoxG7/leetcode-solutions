import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Solution {
  public int minimumDistance(int[] nums) {
    Map<Integer, List<Integer>> indexesByValue = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int value = nums[i];
      indexesByValue.computeIfAbsent(value, key -> new ArrayList<>()).add(i);
    }

    int minimumTupleDistance = Integer.MAX_VALUE;

    for (Map.Entry<Integer, List<Integer>> entry : indexesByValue.entrySet()) {
      List<Integer> indexes = entry.getValue();
      if (Objects.isNull(indexes) || indexes.size() < 3) continue;
      for (int i = 0; i <= indexes.size() - 3; i++) {
        minimumTupleDistance = Math.min(minimumTupleDistance, calculateTupleDistance(indexes.get(i), indexes.get(i + 1), indexes.get(i + 2)));
      }
    }
    
    return minimumTupleDistance == Integer.MAX_VALUE ? -1 : minimumTupleDistance;
  }

  private int calculateTupleDistance(int n1, int n2, int n3) {
    return Math.abs(n1 - n2) + Math.abs(n1 - n3) + Math.abs(n2 - n3);
  }
}