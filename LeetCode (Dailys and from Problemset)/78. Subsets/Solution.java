import java.util.ArrayList;
import java.util.List;

class Solution {
  
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> subset = new ArrayList<>();
    helper(nums, 0, subset, res);
    return res;
  }

  public void helper(int nums[], int i, ArrayList<Integer> subset, List<List<Integer>> res) {
    if (i == nums.length) {
      res.add(new ArrayList<>(subset));
      return;
    }
    subset.add(nums[i]);
    helper(nums, i + 1, subset, res);
    subset.remove(subset.size() - 1);
    helper(nums, i + 1, subset, res);
  }
}