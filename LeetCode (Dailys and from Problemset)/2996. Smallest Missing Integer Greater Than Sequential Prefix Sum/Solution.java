import java.util.HashSet;
import java.util.Set;

class Solution {
  public int missingInteger(int[] nums) {
    int n = nums.length;
    int prefixSum = nums[0];
    int lastOfPrefixIndex = -1;
    for (int i = 0; i < n - 1; i++) {
      int curr = nums[i];
      int next = nums[i + 1];
      if (curr + 1 != next) {
        lastOfPrefixIndex = i;
        break;
      } else {
        prefixSum += next;
      }
    }

    if (lastOfPrefixIndex == -1) return (n > 1) ? prefixSum : prefixSum + 1;
    
    Set<Integer> set = new HashSet<>();
    for (int i = lastOfPrefixIndex; i < n; i++) {
      set.add(nums[i]);
    }

    while (set.contains(prefixSum)) {
      prefixSum++;
    }

    return prefixSum;
  }
}