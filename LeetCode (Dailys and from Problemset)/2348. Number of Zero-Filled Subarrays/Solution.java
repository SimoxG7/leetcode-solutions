class Solution {
  public long zeroFilledSubarray(int[] nums) {
    long currcont = 0;
    long tot = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) currcont++;
      else {
        if (currcont != 0) tot += sum(currcont);
        currcont = 0;
      }
    }
    if (currcont != 0) tot += sum(currcont);
    return tot;
  }

  private long sum(long currcont) {
    long tot = 0;
    for (int i = 1; i <= currcont; i++) {
      tot += i;
    }
    return tot;
  }
}