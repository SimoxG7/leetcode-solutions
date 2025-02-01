class Solution {
  public boolean isArraySpecial(int[] nums) {
    // boolean previousParity = nums[0] % 2 == 0;
    int previousParity = nums[0] & 1;
    for (int i = 1; i < nums.length; i++) {
      // boolean parity = nums[i] % 2 == 0;
      int parity = nums[i] & 1;
      if (parity == previousParity) return false;
      previousParity = parity;
    }
    return true;
  }
}