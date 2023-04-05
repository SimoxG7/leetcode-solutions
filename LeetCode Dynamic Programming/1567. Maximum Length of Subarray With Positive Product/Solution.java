class Solution {
  public int getMaxLen(int[] nums) {
    int pos = 0, neg = 0; // length of positive and negative results
    int res = 0;
    for (int x : nums) {
      if (x == 0) {
        pos = 0;
        neg = 0;
      } else if (x > 0) {
        pos++;
        neg = neg == 0 ? 0 : neg + 1;
      } else {
        int temp = pos;
        pos = neg == 0 ? 0 : neg + 1;
        neg = temp + 1;
      }
      res = Math.max(res, pos);
    }
    return res;
  }
}