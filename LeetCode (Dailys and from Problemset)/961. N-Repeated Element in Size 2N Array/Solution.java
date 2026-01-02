import java.util.HashSet;
import java.util.Set;

class Solution {
  public int repeatedNTimes(int[] nums) {
    Set<Integer> present = new HashSet<>();
    for (int i = 0; i < nums.length; i++) { // will always stop at (nums.length / 2) + 2 at most
      if (!present.add(nums[i])) return nums[i];
    }
    return 0; // unreachable for constraints
  }
}