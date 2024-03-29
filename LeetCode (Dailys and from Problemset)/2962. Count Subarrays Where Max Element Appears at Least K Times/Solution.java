class Solution {
  public long countSubarrays(int[] nums, int k) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) max = Math.max(max, nums[i]);
    long cont = 0;
    int left = 0, right = 0;
    while (right < nums.length) {
      k -= nums[right] == max ? 1 : 0;
      right++;
      while (k == 0) {
        k += nums[left] == max ? 1 : 0;
        left++;
      }
      cont += left;
    }
    return cont;
  }
}