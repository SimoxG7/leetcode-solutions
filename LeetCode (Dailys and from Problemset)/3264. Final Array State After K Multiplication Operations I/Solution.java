class Solution {

  public int[] getFinalState(int[] nums, int k, int multiplier) {
    int minIndex = findMinIndex(nums);
    for (int i = 0; i < k; i++) {
      nums[minIndex] *= multiplier;
      minIndex = findMinIndex(nums);
    }
    return nums;
  }

  private int findMinIndex(int[] nums) {
    int minIndex = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[minIndex]) {
        minIndex = i;
      }    
    }
    return minIndex;
  }
}