class Solution {
  public long maximumTripletValue(int[] nums) {
    long res = 0;
    int maxDiff = 0;
    int maxNum = 0;
    for (final int num : nums) {
      res = Math.max(res, (long) maxDiff * num);
      maxDiff = Math.max(maxDiff, maxNum - num);
      maxNum = Math.max(maxNum, num);
    }
    return res;
  }
}