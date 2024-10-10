import java.util.Arrays;

class Solution {
  public int maxWidthRamp(int[] nums) {
    int[][] z = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++) {
      z[i][0] = i;
      z[i][1] = nums[i];
    }
    Arrays.sort(z, (a, b) -> Integer.compare(a[1], b[1]));
    int maxWidth = 0;
    int minIndex = Integer.MAX_VALUE;
    for (int[] pair : z) {
      int index = pair[0];
      maxWidth = Math.max(maxWidth, index - minIndex);
      minIndex = Math.min(minIndex, index);
    }
    return maxWidth;
  }
}
