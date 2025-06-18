import java.util.Arrays;

public class Solution {
  public int[][] divideArray(int[] nums, int k) {
    Arrays.sort(nums);
    int numArrays = (int) Math.ceil(nums.length / 3.0);
    int[][] ans = new int[numArrays][3];
    for (int i = 0, j = 0; i < nums.length; i += 3, j++) {
      if (i + 2 < nums.length && nums[i + 2] - nums[i] <= k)
        ans[j] = new int[] { nums[i + 2], nums[i + 1], nums[i] };
      else
        return new int[0][0];
    }
    return ans;
  }
}