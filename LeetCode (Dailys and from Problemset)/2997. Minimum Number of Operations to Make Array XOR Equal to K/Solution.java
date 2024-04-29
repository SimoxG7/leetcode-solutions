class Solution {
  public int minOperations(int[] nums, int k) {
    int xor = nums[0];
    for (int i = 1; i < nums.length; i++) {
      xor ^= nums[i];
    }
    if (xor == k) {
      return 0;
    }
    return count(xor, k);
  }

  public int count(int x, int y) {
    int diff = 0;
    for (int i = 0; i < 32; i++) {
      int xLS = ((x >> i) & 1);
      int yLS = ((y >> i) & 1);
      if (xLS != yLS) {
        diff++;
      }
    }
    return diff;
  }
}