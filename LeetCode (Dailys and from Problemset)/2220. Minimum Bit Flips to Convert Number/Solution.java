class Solution {
  public int minBitFlips(int start, int goal) {
    int res = 0;

    while (start > 0 || goal > 0) {
      int rightStart = (start & 1);
      int rightGoal = (goal & 1);

      res += rightStart != rightGoal ? 1 : 0;

      start = start > 0 ? start >> 1 : 0;
      goal = goal > 0 ? goal >> 1 : 0;

    }

    return res;
  }
}