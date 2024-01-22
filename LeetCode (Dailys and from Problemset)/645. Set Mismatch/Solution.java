
class Solution {
  public int[] findErrorNums(int[] nums) {
    boolean[] occurr = new boolean[nums.length+1];
    int dup = -1;
    for (int i = 0; i < nums.length; i++) {
      if (occurr[nums[i]]) dup = nums[i];
      else occurr[nums[i]] = true;
    }
    for (int i = 1; i < occurr.length; i++) {
      if (!occurr[i]) return new int[] {dup, i};
    }
    return null;
  }
}
