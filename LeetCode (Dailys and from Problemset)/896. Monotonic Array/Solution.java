class Solution {
  public boolean isMonotonic(int[] nums) {
    boolean defined = false;
    boolean increasing = false;
    if (nums.length <= 2) return true;
    for (int i = 0; i < nums.length-1; i++) {
      if (nums[i] < nums[i+1]) {
        if (defined && !increasing) return false;
        else {
          defined = true;
          increasing = true;
        }
      } else if (nums[i] > nums[i+1]) {
        if (defined && increasing) return false;
        else {
          defined = true;
          increasing = false;
        }
      }
    }
    return true;
  }
}