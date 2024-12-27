class Solution {
  public int maxScoreSightseeingPair(int[] values) {
    int res = 0, max = 0;
    for (int i = 0; i < values.length; ++i) {
      res = Math.max(res, max + values[i] - i);
      max = Math.max(max, values[i] + i);
    }
    return res;
  }
}