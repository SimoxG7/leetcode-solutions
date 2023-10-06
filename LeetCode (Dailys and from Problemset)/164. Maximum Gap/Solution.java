import java.util.Set;
import java.util.TreeSet;

class Solution {
  public int maximumGap(int[] nums) {
    int n = nums.length; 
    if (n < 2) return 0;
    Set<Integer> set = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      set.add(nums[i]);
    }
    int diff = 0;
    Integer[] vals = set.toArray(new Integer[set.size()]);
    for (int i = 0; i < vals.length-1; i++) {
      diff = Math.max(diff, vals[i+1] - vals[i]);
    }
    return diff;
  }
}