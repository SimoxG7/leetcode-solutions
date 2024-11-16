import java.util.Arrays;

class Solution {
  public int[] resultsArray(int[] nums, int k) {
    int n = nums.length;
    int[] res = new int[n - k + 1];
    Arrays.fill(res, -1);

    int counter = 1;
    for (int i = 0; i < n; i++) {
      if (i > 0 && nums[i] == nums[i - 1] + 1) {
        counter++;
      } else {
        counter = 1;
      }
      if (counter >= k) {
        res[i + 1 - k] = nums[i];
      }
    }
    return res;
  }
}