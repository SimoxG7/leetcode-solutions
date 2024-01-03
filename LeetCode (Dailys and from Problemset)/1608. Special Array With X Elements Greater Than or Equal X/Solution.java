class Solution {
  public int specialArray(int[] nums) {
    int right = nums.length;
    int left = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int count = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] >= mid) count++;
      }
      if (count == mid) return mid;
      else if (count > mid) left = mid + 1;
      else right = mid - 1;
    }
    return -1;
  }
}

