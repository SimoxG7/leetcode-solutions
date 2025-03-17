class Solution {
  public boolean divideArray(int[] nums) {
    int[] occurr = new int[501];
    for (int i = 0; i < nums.length; i++) {
      occurr[nums[i]]++;
    }
    for (int i = 1; i < 501; i++) {
      if (occurr[i] % 2 == 1) return false;
    }
    return true;
  }
}