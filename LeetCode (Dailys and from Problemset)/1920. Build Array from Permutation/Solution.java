//For O(1) space
class Solution {
  public int[] buildArray(int[] nums) {
    for (int i = 0; i < nums.length; i++)
      nums[i] += (1024 * (nums[nums[i]] % 1024));

    for (int i = 0; i < nums.length; i++)
      nums[i] /= 1024;

    return nums;
  }
}

// class Solution {
// public int[] buildArray(int[] nums) {
// int n = nums.length;
// int[] ans = new int[n];
// for (int i = 0; i < n; i++) {
// ans[i] = nums[nums[i]];
// }
// return ans;
// }
// }