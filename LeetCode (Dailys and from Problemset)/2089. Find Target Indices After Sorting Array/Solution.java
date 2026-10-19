
import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> targetIndices(int[] nums, int target) {
    List<Integer> accumulator = new ArrayList<>();
    int lower = 0, equal = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num < target) lower++;
      else if (num == target) equal++;
    }

    for (int i = lower; i < lower + equal; i++) {
      accumulator.add(i);
    }

    return accumulator;
  }
}