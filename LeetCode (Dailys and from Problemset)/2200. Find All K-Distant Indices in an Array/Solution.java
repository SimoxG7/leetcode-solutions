import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    Set<Integer> set = new HashSet<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] == key) {
        for (int j = Math.max(i - k, 0); j <= Math.min(i + k, n - 1); j++) {
          set.add(j);
        }
      }
    }
    List<Integer> lst = set.stream().collect(Collectors.toCollection(ArrayList::new));
    Collections.sort(lst);
    return lst;
  }
}