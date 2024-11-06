class Solution {
  public boolean canSortArray(int[] nums) {
    int currMin = nums[0];
    int currMax = nums[0];
    int prevMax = -1;
    for (int num : nums) {
      if (Integer.bitCount(num) == Integer.bitCount(currMin)) {
        currMin = Math.min(currMin, num);
        currMax = Math.max(currMax, num);
      } else {
        if (currMin < prevMax)
          return false;
        prevMax = currMax;
        currMin = num;
        currMax = num;
      }
    }
    if (currMin < prevMax)
      return false;
    return true;
  }
}