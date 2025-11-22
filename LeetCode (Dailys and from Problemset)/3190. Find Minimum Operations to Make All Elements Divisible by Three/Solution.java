class Solution {
  public int minimumOperations(int[] nums) {
    int cnt = 0;
    for (int i = 0; i < nums.length; i++) {
      int mod = nums[i] % 3;
      cnt += Math.min(mod, 3 - mod);
    }
    return cnt;
  }
}