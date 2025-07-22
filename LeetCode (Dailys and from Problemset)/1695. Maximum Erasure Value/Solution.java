import java.util.HashSet;
import java.util.Set;

class Solution {
  public int maximumUniqueSubarray(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    int max = 0, currSum = 0, index = 0;
    for (int i = 0; i < nums.length; i++) {
      int curr = nums[i];
      
      while (seen.contains(curr)) {
        seen.remove(nums[index]);
        currSum -= nums[index++];
      }

      currSum += curr;
      seen.add(curr);
      max = Math.max(max, currSum);
    }
    return max;
  }
}