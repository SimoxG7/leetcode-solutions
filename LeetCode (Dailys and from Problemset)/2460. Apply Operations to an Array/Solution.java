class Solution {
  public int[] applyOperations(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    int resIndex = 0;

    for (int i = 0; i < n - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        nums[i] <<= 1;
        nums[i + 1] = 0;
      }
      if (nums[i] != 0) {
        res[resIndex++] = nums[i];
      }
    }
    if (nums[n - 1] != 0) res[resIndex] = nums[n - 1];
    return res;
  }
}