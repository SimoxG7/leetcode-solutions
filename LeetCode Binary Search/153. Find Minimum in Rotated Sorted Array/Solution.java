class Solution {
  public int findMin(int[] nums) {
    //find rotation
    int left = 0;
    int right = nums.length-1;

    while (left < right) {
      int mid = (right + left)/2;
      if (nums[mid] < nums[right]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return nums[left];
  }
}