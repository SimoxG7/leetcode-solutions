import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
  public int[] smallestSubarrays(int[] nums) {
    int n = nums.length;
    List<Integer> temp = new ArrayList<>();
    int[] nextSetBitPos = new int[32];
    Arrays.fill(nextSetBitPos, -1);

    for (int i = n - 1; i >= 0; i--) {
      int curr = nums[i];
      int pos = 0;

      while (curr > 0) {
        if ((curr & 1) == 1) {
          nextSetBitPos[pos] = i;
        }
        curr >>= 1;
        pos++;
      }

      int maxIdx = -1;
      for (int idx : nextSetBitPos) {
        if (idx != -1) {
          maxIdx = Math.max(maxIdx, idx);
        }
      }

      if (maxIdx == -1) {
        temp.add(1);
      } else {
        temp.add(maxIdx - i + 1);
      }
    }

    Collections.reverse(temp);
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      ans[i] = temp.get(i);
    }
    return ans;
  }
}