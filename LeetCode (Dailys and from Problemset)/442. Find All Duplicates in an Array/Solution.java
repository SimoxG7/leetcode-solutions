import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    int n = nums.length + 1;
    List<Integer> doubles = new ArrayList<>();
    boolean[] appearedOnce = new boolean[n];
    for (int i = 0; i < nums.length; i++) {
      if (appearedOnce[nums[i]]) doubles.add(nums[i]);
      else appearedOnce[nums[i]] = true;
    }
    return doubles;
  }
}