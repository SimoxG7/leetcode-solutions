import java.util.List;

class Solution {
  public int maxIncreasingSubarrays(List<Integer> nums) {
    int n = nums.size();

    int prevK = 1;
    int k = 1;
    int res = 1;

    for (int i = 0; i < n - 1; i++) {
      if (nums.get(i + 1) > nums.get(i))
        k++;
      else {
        prevK = k;
        k = 1;
      }
      res = Math.max(res, Math.min(prevK, k));
      res = Math.max(res, k / 2);
    }

    return res;
  }
}