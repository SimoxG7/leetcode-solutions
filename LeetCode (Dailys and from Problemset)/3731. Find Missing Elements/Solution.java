import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> findMissingElements(int[] nums) {
    int max = nums[0];
    int min = nums[0];

    for (int i : nums) {
      max = Math.max(i, max);
      min = Math.min(i, min);
    }

    int[] arr = new int[max + 1];
    for (int i : nums) {
      arr[i]++;
    }

    List<Integer> res = new ArrayList<>();
    for (int i = min; i < max; i++) {
      if (arr[i] == 0)
        res.add(i);
    }
    return res;

  }
}