import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums.length == 0) return result; //necessary or IndexOOB
    int start = nums[0];
    int last = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == last + 1) {
        last = nums[i];
      } else {
        adder(start, last, result);
        start = nums[i];
        last = start;
      }
    }
    adder(start, last, result);
    return result;
  }

  private void adder(int start, int last, List<String> result) {
    if (start == last) {
      result.add(Integer.toString(start));
    } else {
      result.add(start + "->" + last);
    }
  }
}