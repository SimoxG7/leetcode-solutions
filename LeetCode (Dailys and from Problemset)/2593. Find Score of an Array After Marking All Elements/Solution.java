import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public long findScore(int[] nums) {
    if (nums.length == 1)
      return nums[0];
    long res = 0;
    boolean[] isMarked = new boolean[nums.length];
    int[][] arr = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++) {
      arr[i][0] = nums[i];
      arr[i][1] = i;
    }

    Arrays.sort(arr, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
      }
    });

    for (int[] a : arr) {
      int val = a[0];
      int idx = a[1];
      if (!isMarked[idx]) {
        res += val;
        isMarked[idx] = true;
        if (idx == 0)
          isMarked[idx + 1] = true;
        else if (idx == nums.length - 1)
          isMarked[idx - 1] = true;
        else {
          isMarked[idx + 1] = true;
          isMarked[idx - 1] = true;
        }
      }
    }
    return res;
  }
}