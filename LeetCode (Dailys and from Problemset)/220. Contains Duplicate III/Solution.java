import java.util.TreeSet;

class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
    if (nums == null || nums.length < 2 || indexDiff < 1) return false;
    TreeSet<Long> set = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      long l = (long) nums[i];
      Long floor = set.floor(l);
      Long ceil = set.ceiling(l);
      if ((floor != null && l - floor <= valueDiff) || (ceil != null && ceil - l <= valueDiff)) return true;
      set.add(l);
      if (i >= indexDiff) set.remove((long) nums[i - indexDiff]);
    }
    return false;
  }
}