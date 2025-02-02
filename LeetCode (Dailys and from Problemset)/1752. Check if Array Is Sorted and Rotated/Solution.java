class Solution {
  public boolean check(int[] nums) {
    int n = nums.length;
    boolean foundDecrease = false;
    for (int i = 0; i < n - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        if (foundDecrease) return false;
        foundDecrease = true;
      }
    }
    return !(foundDecrease && nums[n - 1] > nums[0]);
  }
}