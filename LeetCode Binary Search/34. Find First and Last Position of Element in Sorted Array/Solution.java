class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    res[0] = search(nums, target, true);
    res[1] = search(nums, target, false);
    return res;
  }

  private int search(int[] nums, int target, boolean first) {
    int left = 0;
    int right = nums.length-1;
    int res = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) left = mid + 1;
      else if (nums[mid] > target) right = mid - 1;
      else {
        res = mid;
        if (first) right = mid - 1;
        else left = mid + 1;
      } 
    }
    return res;
  }
}
