class Solution {
  public int longestSubsequence(int[] nums) {
    int xor = 0;
    boolean hasNonZero = false;

    for (int x : nums) {
      if (x != 0) {
        hasNonZero = true;
      }
      xor ^= x;
    }

    if (xor != 0) {
      return nums.length;
    }

    if (hasNonZero) {
      return nums.length - 1;
    }

    return 0;
  }
}