class Solution {
  public int longestSubarray(int[] nums) {
    int max = 0;
    for (int num : nums) {
      max = Math.max(max, num);
    }

    int len = 0;
    int res = 0;
    for (int num : nums) {
      if (num == max) {
        len++;
        res = Math.max(res, len);
      } else {
        len = 0;
      }
    }
    return res;
  }
}