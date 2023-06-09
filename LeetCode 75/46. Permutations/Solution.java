import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(res, new ArrayList<>(), nums);
    return res;
  }

  private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums) {
    if (temp.size() == nums.length) {
      res.add(new ArrayList<>(temp));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (temp.contains(nums[i]))
          continue; // element already exists, skip
        temp.add(nums[i]);
        backtrack(res, temp, nums);
        temp.remove(temp.size() - 1);
      }
    }
  }
}