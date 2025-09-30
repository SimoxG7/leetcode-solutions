import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class Solution {

  private final Map<Integer, List<Integer>> map;
  private final Random random;

  public Solution(int[] nums) {
    random = new Random();
    map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.computeIfAbsent(nums[i], _ -> new ArrayList<>()).add(i);
    }
  }

  public int pick(int target) {
    List<Integer> lst = map.get(target);
    int pickIndex = random.nextInt(lst.size());
    return lst.get(pickIndex);
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */