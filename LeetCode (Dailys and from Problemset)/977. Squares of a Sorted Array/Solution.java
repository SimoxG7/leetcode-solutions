class Solution {
  public int[] sortedSquares(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    int left = 0, right = n - 1, end = n - 1;
    while (left <= right) {
      if (Math.abs(nums[left]) > Math.abs(nums[right])) {
        res[end--] = nums[left] * nums[left++];
      } else {
        res[end--] = nums[right] * nums[right--];
      }
    }
    return res;
  }
}