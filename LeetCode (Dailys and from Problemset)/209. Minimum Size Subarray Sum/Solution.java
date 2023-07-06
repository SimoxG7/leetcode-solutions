class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    int min = Integer.MAX_VALUE;
    if (nums.length == 1) return nums[0] >= target ? 1 : 0;
    int leftindex = 0;
    int rightindex = 0;
    int currsum = 0;
    while (rightindex < nums.length) {
      if (currsum >= target) {
        min = Math.min(min, rightindex-leftindex);
        currsum -= nums[leftindex++];
      } else {
        currsum += nums[rightindex++];
        // if (currsum >= target) {
        //   min = Math.min(min, rightindex-leftindex);
        // }
      }
    }
    if (currsum >= target) min = Math.min(min, rightindex - leftindex);
    while (leftindex < rightindex) {
      if (currsum - nums[leftindex] >= target) {
        currsum -= nums[leftindex];
        min = Math.min(min, rightindex - ++leftindex);
      } else {
        break;
      }
    }
    if (min == Integer.MAX_VALUE) return 0;
    return min;
  }
}