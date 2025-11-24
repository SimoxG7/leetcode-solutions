import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Boolean> prefixesDivBy5(int[] nums) {
    int n = nums.length;
    List<Boolean> lst = new ArrayList<>(n);
    int curr = 0;
    for (int i = 0; i < n; i++) {
      curr = ((curr << 1) + nums[i]) % 5;
      lst.add(curr == 0);
    }
    return lst;
  }
}